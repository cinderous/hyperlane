package net.cinderous.hyperlane.client.entity.model;

import net.cinderous.hyperlane.entities.HyphinitySwoop;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class HyphinitySwoopModel<T extends HyphinitySwoop> extends EntityModel<T> {
    private final ModelRenderer Body;
    private final ModelRenderer Head;
    private final ModelRenderer LeftWing;
    private final ModelRenderer LeftWingTip;
    private final ModelRenderer RightWing;
    private final ModelRenderer RightWingTip;

    public HyphinitySwoopModel() {
        textureWidth = 16;
        textureHeight = 16;

        Body = new ModelRenderer(this);
        Body.setRotationPoint(0.0F, 24.0F, 4.0F);
        Body.setTextureOffset(0, 0).addBox(-2.0F, -8.0F, -4.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
        Body.setTextureOffset(0, 0).addBox(-2.0F, -7.0F, -1.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);
        Body.setTextureOffset(0, 0).addBox(-1.0F, -6.0F, 1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        Head = new ModelRenderer(this);
        Head.setRotationPoint(0.0F, 2.0F, -7.0F);
        Body.addChild(Head);
        Head.setTextureOffset(0, 0).addBox(-2.0F, -10.0F, -2.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);
        Head.setTextureOffset(0, 0).addBox(-1.0F, -9.0F, -4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        Head.setTextureOffset(0, 0).addBox(-1.0F, -10.0F, 0.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

        LeftWing = new ModelRenderer(this);
        LeftWing.setRotationPoint(0.0F, 0.0F, 0.0F);
        Body.addChild(LeftWing);
        LeftWing.setTextureOffset(0, 0).addBox(1.0F, -6.0F, -4.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);

        LeftWingTip = new ModelRenderer(this);
        LeftWingTip.setRotationPoint(1.0F, 0.0F, 0.0F);
        LeftWing.addChild(LeftWingTip);
        setRotationAngle(LeftWingTip, 0.0F, 0.0F, -0.3491F);
        LeftWingTip.setTextureOffset(0, 0).addBox(4.0F, -5.1761F, -4.0F, 6.0F, 1.0F, 3.0F, 0.0F, false);

        RightWing = new ModelRenderer(this);
        RightWing.setRotationPoint(0.0F, 0.0F, 0.0F);
        Body.addChild(RightWing);
        RightWing.setTextureOffset(0, 0).addBox(-5.0F, -6.0F, -4.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);

        RightWingTip = new ModelRenderer(this);
        RightWingTip.setRotationPoint(-1.0F, 1.0F, 0.0F);
        RightWing.addChild(RightWingTip);
        setRotationAngle(RightWingTip, 0.0F, 0.0F, 0.3491F);
        RightWingTip.setTextureOffset(0, 0).addBox(-10.9659F, -5.7412F, -4.0F, 6.0F, 1.0F, 3.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        Body.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}