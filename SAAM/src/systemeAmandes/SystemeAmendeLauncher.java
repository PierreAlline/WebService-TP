package systemeAmandes;

import javax.xml.ws.Endpoint;

public class SystemeAmendeLauncher {
	public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/ws/amende", new SystemeAmendesImpl());
    }
}
