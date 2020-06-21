package net.cinderous.hyperlane.client.entity.model.render;

import net.cinderous.hyperlane.Hyperlane;
import net.cinderous.hyperlane.client.entity.model.HyphinitySwoopModel;
import net.cinderous.hyperlane.entities.HyphinitySwoop;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class HyphinitySwoopRender extends MobRenderer<HyphinitySwoop, HyphinitySwoopModel<HyphinitySwoop>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Hyperlane.MOD_ID,
            "textures/entities/hyphinity_swoop.png");

    public HyphinitySwoopRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new HyphinitySwoopModel<HyphinitySwoop>(), 0.5f);
    }

    @Override
    public ResourceLocation getEntityTexture(HyphinitySwoop entity)
        {
            return TEXTURE;
        }

}