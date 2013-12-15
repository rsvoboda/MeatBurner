package wolfc.meatburner;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * A very simplistic mod that burns cooked meat into bones.
 */
@Mod(modid="MeatBurnerModID", name="Meat Burner", version="0.0.1")
@NetworkMod(serverSideRequired = true)
public class MeatBurnerMod {

    // The instance of your mod that Forge uses.
    @Instance(value = "GenericModID")
    public static MeatBurnerMod instance;

    // Says where the client and server 'proxy' code is loaded.
//    @SidedProxy(clientSide="tutorial.generic.client.ClientProxy", serverSide="tutorial.generic.CommonProxy")
//    public static CommonProxy proxy;

    @EventHandler // used in 1.6.2
    //@PreInit    // used in 1.5.2
    public void preInit(FMLPreInitializationEvent event) {
        // Stub Method
    }

    @EventHandler // used in 1.6.2
    //@Init       // used in 1.5.2
    public void load(FMLInitializationEvent event) {
//        proxy.registerRenderers();

        // get bones from burning steak
        GameRegistry.addSmelting(Item.beefCooked.itemID, new ItemStack(Item.bone), 0.1f);

        // get string from unravelling wool
        GameRegistry.addShapelessRecipe(new ItemStack(Item.silk, 4), Block.cloth);

        // get slime ball from leaves
        for(int t = 0; t < BlockLeaves.LEAF_TYPES.length; t++) {
            final ItemStack leavesStack = new ItemStack(Block.leaves, 1, t);
            GameRegistry.addShapelessRecipe(new ItemStack(Item.slimeBall), leavesStack, leavesStack, leavesStack, leavesStack);
        }
    }

    @EventHandler // used in 1.6.2
    //@PostInit   // used in 1.5.2
    public void postInit(FMLPostInitializationEvent event) {
        // Stub Method
    }
}