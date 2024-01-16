package jaggwagg.my_mod_id.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

import java.util.Locale;

public enum ModItems {
    MY_ITEM(new MyItem(new FabricItemSettings()));

    public final String id;
    public final Item item;

    <T extends Item> ModItems(T item) {
        this.id = this.toString().toLowerCase(Locale.ROOT);
        this.item = item;
    }

    public String getId() {
        return this.id;
    }

    public Item getItem() {
        return this.item;
    }
}
