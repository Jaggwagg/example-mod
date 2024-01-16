package jaggwagg.my_mod_id.block.entity;

import jaggwagg.my_mod_id.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;

import java.util.Locale;

public enum ModBlockEntityTypes {
    MY_BLOCK_ENTITY(FabricBlockEntityTypeBuilder.create(MyBlockEntity::new, ModBlocks.MY_BLOCK_WITH_BLOCK_ENTITY.getBlock()).build());

    private final String id;
    private final BlockEntityType<? extends BlockEntity> getBlockEntityType;

    ModBlockEntityTypes(BlockEntityType<? extends BlockEntity> getBlockEntityType) {
        this.id = this.toString().toLowerCase(Locale.ROOT);
        this.getBlockEntityType = getBlockEntityType;
    }

    public String getId() {
        return this.id;
    }

    public BlockEntityType<? extends BlockEntity> getBlockEntityType() {
        return this.getBlockEntityType;
    }
}
