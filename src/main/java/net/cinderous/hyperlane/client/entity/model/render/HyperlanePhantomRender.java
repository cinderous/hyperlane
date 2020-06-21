package net.cinderous.hyperlane.client.entity.model.render;

import net.cinderous.hyperlane.Hyperlane;
import net.cinderous.hyperlane.client.entity.model.HyperlanePhantomModel;
import net.cinderous.hyperlane.entities.HyperlanePhantom;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class HyperlanePhantomRender extends MobRenderer<HyperlanePhantom, HyperlanePhantomModel<HyperlanePhantom>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Hyperlane.MOD_ID,
            "textures/entities/hyperlane_phantom.png");

    public HyperlanePhantomRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new HyperlanePhantomModel<HyperlanePhantom>(), 0.5f);
    }

    @Override
    public ResourceLocation getEntityTexture(HyperlanePhantom entity) {
        return TEXTURE;
    }

}