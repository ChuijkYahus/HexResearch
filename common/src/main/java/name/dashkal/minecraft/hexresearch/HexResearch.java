package name.dashkal.minecraft.hexresearch;

import name.dashkal.minecraft.hexresearch.config.ClientConfig;
import name.dashkal.minecraft.hexresearch.config.CommonConfig;
import name.dashkal.minecraft.hexresearch.config.ServerConfig;
import name.dashkal.minecraft.hexresearch.event.Events;
import name.dashkal.minecraft.hexresearch.interop.Interop;
import name.dashkal.minecraft.hexresearch.registry.*;
import name.dashkal.minecraft.hexresearch.network.Networking;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Common entry point for HexResearch.
 * <p>
 * See HexResearchForge and HexResearchFabric for the per-platform entry points.
 */
public class HexResearch {
    public static final String MOD_ID = "hexresearch";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    private static final ClientConfig clientConfig = ClientConfig.getDefault();
    private static final CommonConfig commonConfig = CommonConfig.getDefault();
    private static final ServerConfig serverConfig = ServerConfig.getDefault();

    public static void init() {
        LOGGER.info("Hex Research Initializing");

        // Minecraft / Forge / Fabric Registries
        HRBlocks.init();
        HRBlockEntities.init();
        HRItems.init();
        HRIotaTypes.init();
        HRHexPatterns.init();
        HREffects.init();
        HRAdvancementTriggers.init();

        // Events
        Events.init();

        // Networking
        Networking.init();

        // HexResearch internals
        HRMindHarms.init();

        // Interop
        Interop.init();
    }

    public static ClientConfig getClientConfig() {
        return clientConfig;
    }

    public static CommonConfig getCommonConfig() {
        return commonConfig;
    }

    public static ServerConfig getServerConfig() {
        return serverConfig;
    }

    /**
     * Shortcut for identifiers specific to this mod.
     */
    public static ResourceLocation id(String string) {
        return new ResourceLocation(MOD_ID, string);
    }
}
