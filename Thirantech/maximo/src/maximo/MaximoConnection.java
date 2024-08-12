package maximo;
import psdi.mbo.MboRemote;
import psdi.mbo.MboSetRemote;
import psdi.util.MXSession;

public class MaximoConnection {
    public static void main(String[] args) {
        try {
            // Establish connection to Maximo server
            MXSession session = getConnection("192.168.18.128", 13400, "MXServer", "maxadmin", "maxadmin");

            // Retrieve the set of assets
            MboSetRemote assetSet = session.getMboSet("ASSET");
            assetSet.setOrderBy("ASSETNUM");

            // Iterate through the assets and print details
            MboRemote asset;
            for (int i = 0; (asset = assetSet.getMbo(i)) != null; i++) {
                String assetNum = asset.getString("ASSETNUM");
                String location = asset.getString("LOCATION");
                String description = asset.getString("DESCRIPTION");
                System.out.println(assetNum + " - " + location + " - " + description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static MXSession getConnection(String host, int rmiPort, String serverName, String user, String password) {
        MXSession session = MXSession.getSession();
        String connectionHost = host + ":" + rmiPort + "/" + serverName;
        session.setHost(connectionHost);
        session.setUserName(user);
        session.setPassword(password);
        try {
            session.connect();
            System.out.println("Connection successful");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return session;
    }
}

