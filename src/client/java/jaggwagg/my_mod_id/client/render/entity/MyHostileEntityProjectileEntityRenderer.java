/*
 * Decompiled with CFR 0.2.1 (FabricMC 53fa44c9).
 */
package jaggwagg.my_mod_id.client.render.entity;

import jaggwagg.my_mod_id.entity.projectile.MyHostileProjectileEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.LlamaSpitEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

public class MyHostileEntityProjectileEntityRenderer extends EntityRenderer<MyHostileProjectileEntity> {
    private static final Identifier TEXTURE = new Identifier("textures/entity/llama/spit.png");
    private final LlamaSpitEntityModel<MyHostileProjectileEntity> model;

    public MyHostileEntityProjectileEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new LlamaSpitEntityModel<>(context.getPart(EntityModelLayers.LLAMA_SPIT));
    }

    @Override
    public void render(MyHostileProjectileEntity llamaSpitEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.translate(0.0f, 0.15f, 0.0f);
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(g, llamaSpitEntity.prevYaw, llamaSpitEntity.getYaw()) - 90.0f));
        matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp(g, llamaSpitEntity.prevPitch, llamaSpitEntity.getPitch())));
        this.model.setAngles(llamaSpitEntity, g, 0.0f, -0.1f, 0.0f, 0.0f);
        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(this.model.getLayer(TEXTURE));
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);
        matrixStack.pop();
        super.render(llamaSpitEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(MyHostileProjectileEntity llamaSpitEntity) {
        return TEXTURE;
    }
}
