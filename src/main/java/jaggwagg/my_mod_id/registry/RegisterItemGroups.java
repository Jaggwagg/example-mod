package jaggwagg.my_mod_id.registry;

import jaggwagg.my_mod_id.MyMod;
import jaggwagg.my_mod_id.item.ModItemGroups;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;

import java.util.Arrays;

public class RegisterItemGroups {
    public static void init() {
        Arrays.stream(ModItemGroups.values()).forEach(value -> registerItemGroup(value.getId(), value.getItemGroupItem(), value.getItemGroup()));
    }

    private static void registerItemGroup(String id, Item item, RegistryKey<ItemGroup> itemGroup) {
        Registry.register(Registries.ITEM_GROUP, itemGroup, FabricItemGroup.builder()
                .icon(() -> new ItemStack(item))
                .displayName(Text.translatable("group." + MyMod.MOD_ID + "." + id))
                .build());
    }
}
