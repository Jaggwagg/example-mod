package jaggwagg.my_mod_id.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class MyBlockEntity extends BlockEntity {
    public MyBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.MY_BLOCK_ENTITY.getBlockEntityType(), pos, state);
    }
}
