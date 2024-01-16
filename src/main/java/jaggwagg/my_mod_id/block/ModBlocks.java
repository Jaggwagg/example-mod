package jaggwagg.my_mod_id.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;

import java.util.Locale;

public enum ModBlocks {
    MY_BLOCK(new MyBlock(FabricBlockSettings.create())),
    MY_BLOCK_WITH_BLOCK_ENTITY(new MyBlockWithEntityBlock(FabricBlockSettings.create()));

    private final String id;
    private final Block block;

    <T extends Block> ModBlocks(T block) {
        this.id = this.toString().toLowerCase(Locale.ROOT);
        this.block = block;
    }

    public String getId() {
        return this.id;
    }

    public Block getBlock() {
        return this.block;
    }
}
