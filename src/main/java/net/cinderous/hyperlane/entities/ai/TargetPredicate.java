package net.cinderous.hyperlane.entities.ai;

import net.minecraft.entity.LivingEntity;
import org.antlr.v4.runtime.misc.Predicate;

import javax.annotation.Nullable;

public class TargetPredicate {

    private Predicate<LivingEntity> predicate;

    public TargetPredicate setPredicate(@Nullable Predicate<LivingEntity> predicate) {
        this.predicate = predicate;
        return this;
    }
}
