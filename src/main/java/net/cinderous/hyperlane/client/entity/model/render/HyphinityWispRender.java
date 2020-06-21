package net.cinderous.hyperlane.client.entity.model.render;

import net.cinderous.hyperlane.Hyperlane;
import net.cinderous.hyperlane.client.entity.model.HyphinityWispModel;
import net.cinderous.hyperlane.entities.HyphinityWisp;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class HyphinityWispRender extends MobRenderer<HyphinityWisp, HyphinityWispModel<HyphinityWisp>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Hyperlane.MOD_ID,
            "textures/entities/hyphinity_wisp.png");

    public HyphinityWispRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new HyphinityWispModel<HyphinityWisp>(), 0.5f);
    }

    @Override
    public ResourceLocation getEntityTexture(HyphinityWisp entity) {
        return TEXTURE;
    }

}