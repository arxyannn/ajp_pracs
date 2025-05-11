import java.util.*;

// Interface for modular ad logic (OCP, DIP)
interface AdModule {
    void execute(String adType);
}

// Analytics Module (SRP)
class AnalyticsModule implements AdModule {
    public void execute(String adType) {
        System.out.println("Logging analytics for: " + adType);
    }
}

// Marketing Module (SRP)
class MarketingModule implements AdModule {
    public void execute(String adType) {
        if (adType.equalsIgnoreCase("Video")) {
            System.out.println("Start campaign tracking for Video Ad");
        }
    }
}

// AdManager (SRP, uses composition to extend behavior)
class AdManager {
    private List<AdModule> modules = new ArrayList<>();

    public void registerModule(AdModule module) {
        modules.add(module);
    }

    public void serveAd(String adType) {
        System.out.println("Serving Ad: " + adType);
        for (AdModule module : modules) {
            module.execute(adType);
        }
    }
}

// Main application class
public class AdApp {
    public static void main(String[] args) {
        AdManager manager = new AdManager();
        manager.registerModule(new AnalyticsModule());
        manager.registerModule(new MarketingModule());

        // Simulate ad serving
        manager.serveAd("Video");
        System.out.println();
        manager.serveAd("Banner");
    }
}
