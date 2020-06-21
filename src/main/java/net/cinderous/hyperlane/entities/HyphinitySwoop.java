package net.cinderous.hyperlane.entities;

import net.cinderous.hyperlane.util.RegistryHandler;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.IFlyingAnimal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class HyphinitySwoop extends CreatureEntity implements IFlyingAnimal {



    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public CreatureAttribute getCreatureAttribute() {
        return CreatureAttribute.WATER;
    }

    @Override
    public boolean isNotColliding(IWorldReader worldIn) {
        return worldIn.checkNoEntityCollision(this);
    }


    private EatGrassGoal eatGrassGoal;
    private int exampleTimer;

    public HyphinitySwoop(EntityType<? extends HyphinitySwoop> type, World worldIn) {
        super(type, worldIn);

        setPathPriority(PathNodeType.LAVA, 8f);
        setPathPriority(PathNodeType.DANGER_FIRE, 0f);
        setPathPriority(PathNodeType.DAMAGE_FIRE, 0f);
        this.moveController = new FlyingMovementController(this, 20, true);
    }

    @Override
    protected PathNavigator createNavigator(World world) {
        FlyingNavigator nav = new FlyingNavigator(this, world);
        nav.setCanOpenDoors(false);
        nav.setCanEnterDoors(false);
        return nav;
    }

    public static void registerPlacementType(EntityType type, EntitySpawnPlacementRegistry.PlacementType spawnType) {
        EntitySpawnPlacementRegistry.register(type, spawnType, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::canAnimalSpawn);
    }

    public static void registerPlacementTypes() {
        registerPlacementType(RegistryHandler.HYPHINITY_SWOOP.get(), EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS);
    }


    @Override
    protected void registerGoals() {
        super.registerGoals();
        //CreatureEntity thiscreature = new CreatureEntity(RegistryHandler.HYPHINITY_SWOOP.get() ,this.world.getWorld() ) {
       // }
           this.goalSelector.addGoal(5, new MoveTowardsTargetGoal(this, 1d, 40));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 0.8d));
        this.goalSelector.addGoal(8, new LookAtWithoutMovingGoal(this, PlayerEntity.class, 8f, 0.01f));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AnimalEntity.class, true, false));
    }

//    @Override
//    protected void updateAITasks() {
//        this.exampleTimer = this.eatGrassGoal.getEatingGrassTimer();
//        super.updateAITasks();
//    }

    @Override
    public void livingTick() {
        if (this.world.isRemote) {
            this.exampleTimer = Math.max(0, this.exampleTimer - 1);
        }

        super.livingTick();
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(16.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23D);
        getAttributes().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
        getAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.9d);
    }

    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 10) {
            this.exampleTimer = 40;
        } else {
            super.handleStatusUpdate(id);
        }

    }

    @OnlyIn(Dist.CLIENT)
    public float getHeadRotationPointY(float p_70894_1_) {
        if (this.exampleTimer <= 0) {
            return 0.0F;
        } else if (this.exampleTimer >= 4 && this.exampleTimer <= 36) {
            return 1.0F;
        } else {
            return this.exampleTimer < 4 ? ((float) this.exampleTimer - p_70894_1_) / 4.0F
                    : -((float) (this.exampleTimer - 40) - p_70894_1_) / 4.0F;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public float getHeadRotationAngleX(float p_70890_1_) {
        if (this.exampleTimer > 4 && this.exampleTimer <= 36) {
            float f = ((float) (this.exampleTimer - 4) - p_70890_1_) / 32.0F;
            return ((float) Math.PI / 5F) + 0.21991149F * MathHelper.sin(f * 28.7F);
        } else {
            return this.exampleTimer > 0 ? ((float) Math.PI / 5F) : this.rotationPitch * ((float) Math.PI / 180F);
        }
    }




    @Override
    public void onStruckByLightning(LightningBoltEntity lightningBolt) {
        this.setGlowing(true);
    }



}
