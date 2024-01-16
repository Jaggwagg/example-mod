package jaggwagg.my_mod_id.registry;

import jaggwagg.my_mod_id.MyMod;
import jaggwagg.my_mod_id.block.ModBlocks;
import jaggwagg.my_mod_id.item.ModItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.Arrays;

public class RegisterBlocks {
    public static void init() {
        Arrays.stream(ModBlocks.values()).forEach(value -> registerBlockWithItem(value.getId(), value.getBlock()));
    }

    public static void registerBlockWithItem(String name, Block block) {
        Registry.register(Registries.BLOCK, new Identifier(MyMod.MOD_ID, name), block);
        BlockItem item = Registry.register(Registries.ITEM, new Identifier(MyMod.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(ModItemGroups.MY_MOD.getItemGroup()).register(content -> content.add(item));
    }
}
