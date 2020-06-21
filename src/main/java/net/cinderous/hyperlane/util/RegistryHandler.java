package net.cinderous.hyperlane.util;

import net.cinderous.hyperlane.Hyperlane;


import net.cinderous.hyperlane.effects.HyperlaneEffect;
import net.cinderous.hyperlane.entities.HyperlanePhantom;
import net.cinderous.hyperlane.entities.HyphinitySwoop;
import net.cinderous.hyperlane.entities.HyphinityWisp;

import net.cinderous.hyperlane.items.*;
import net.cinderous.hyperlane.util.enums.ModArmorTiers;
import net.cinderous.hyperlane.util.enums.ModItemTiers;

import net.cinderous.hyperlane.blocks.*;
import net.cinderous.hyperlane.containers.HyperlaneFurnaceContainer;
import net.cinderous.hyperlane.containers.HyperlaneStaffPedestalContainer;
import net.cinderous.hyperlane.tileentities.*;
import net.cinderous.hyperlane.world.biomes.*;
import net.cinderous.hyperlane.world.dimensions.*;
import net.cinderous.hyperlane.world.feature.*;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.*;
import net.minecraft.potion.*;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class RegistryHandler {


    public static final DeferredRegister<SoundEvent> SOUNDS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS, Hyperlane.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Hyperlane.MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS = new DeferredRegister<>(ForgeRegistries.FLUIDS, Hyperlane.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Hyperlane.MOD_ID);
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, Hyperlane.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, Hyperlane.MOD_ID);
    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPE_DEFERRED_REGISTER = new DeferredRegister<>(ForgeRegistries.CONTAINERS, Hyperlane.MOD_ID);
    public static final DeferredRegister<Effect> POTIONS = new DeferredRegister<>(ForgeRegistries.POTIONS, Hyperlane.MOD_ID);
    public static final DeferredRegister<Potion> POTION_EFFECTS = new DeferredRegister<>(ForgeRegistries.POTION_TYPES, Hyperlane.MOD_ID);
    public static final DeferredRegister<Feature<?>> FEATURE_TYPES = new DeferredRegister<>(ForgeRegistries.FEATURES, Hyperlane.MOD_ID);

    public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, Hyperlane.MOD_ID);
    //


    public static void init() {

        SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        POTIONS.register(FMLJavaModLoadingContext.get().getModEventBus());
        POTION_EFFECTS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        FEATURE_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILE_ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        CONTAINER_TYPE_DEFERRED_REGISTER.register(FMLJavaModLoadingContext.get().getModEventBus());
        BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
        MOD_DIMENSIONS.register(FMLJavaModLoadingContext.get().getModEventBus());

    }



    //Items
    public static final RegistryObject<Item> DIMENSIONAL_BRIDGE_BUILDER = ITEMS.register("dimensional_bridge_builder", DimensionalBridgeBuilder::new);



    //potion effects
    public static final RegistryObject<Effect> HYPERLANE_EFFECT = POTIONS.register("hyperlane_effect",
            () -> new HyperlaneEffect(EffectType.NEUTRAL, 37848743).addAttributesModifier(
                    SharedMonsterAttributes.ATTACK_SPEED, "AF8B6E3F-3328-4C0A-AA36-5BA2BB9DBEF3", 1.0D,
                    AttributeModifier.Operation.ADDITION));

    public static final RegistryObject<Effect> HYPHINITY_SICKNESS_GRAVITY = POTIONS.register("hyphinity_sickness_gravity",
            () -> new HyperlaneEffect(EffectType.HARMFUL, 37848743));


        //hyperlane items
    public static final RegistryObject<Item> HYPERLANE_STAFF = ITEMS.register("hyperlane_staff", HyperlaneStaff::new);
    public static final RegistryObject<Item> HYPHINITY_WISP_INJECTOR = ITEMS.register("hyphinity_wisp_injector", HyphinityWispInjector::new);
    public static final RegistryObject<Item> HYPERLANE_GEL_RESIDUE = ITEMS.register("hyperlane_gel_residue", HyperlaneItemBase::new);
    public static final RegistryObject<Item> HYPHERIUM_INGOT = ITEMS.register("hypherium_ingot", HyperlaneItemBase::new);

    public static final RegistryObject<Item> HYPHINITY_STAFF = ITEMS.register("hyphinity_staff", HyphinityStaff::new);


    public static final RegistryObject<HyphinityPickaxe> HYPHINITY_PICKAXE = ITEMS.register("hyphinity_pickaxe",
            () -> new HyphinityPickaxe( ModItemTiers.HYPHINITY_PICKAXE_CONFIG, 6, -3.2f, new Item.Properties().group(Hyperlane.HYPERLANE_TAB)));

    public static final RegistryObject<AxeItem> HYPHINITY_AXE = ITEMS.register("hyphinity_axe",
            () -> new AxeItem( ModItemTiers.HYPHINITY_AXE_CONFIG, 6, -3.2f, new Item.Properties().group(Hyperlane.HYPERLANE_TAB)));

    public static final RegistryObject<ShovelItem> HYPHINITY_SHOVEL = ITEMS.register("hyphinity_shovel",
            () -> new ShovelItem( ModItemTiers.HYPHINITY_SHOVEL_CONFIG, 6, -3.2f, new Item.Properties().group(Hyperlane.HYPERLANE_TAB)));

//    public static final RegistryObject<HoeItem> HYPHINITY_HOE = ITEMS.register("hyphinity_hoe",
//            () -> new HoeItem( ModItemTiers.HYPHINITY_HOE_CONFIG, 6, new Item.Properties().group(CrystalArchitect.HYPERLANE_TAB)));

    public static final RegistryObject<ArmorItem> HYPHINITY_HELMET = ITEMS.register("hyphinity_helmet",
            () -> new ArmorItem(ModArmorTiers.HYPHINITY_ARMOR_CONFIG,EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<ArmorItem> HYPHINITY_CHESTPLATE = ITEMS.register("hyphinity_chestplate",
            () -> new ArmorItem(ModArmorTiers.HYPHINITY_ARMOR_CONFIG,EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<ArmorItem> HYPHINITY_LEGGINGS = ITEMS.register("hyphinity_leggings",
            () -> new ArmorItem(ModArmorTiers.HYPHINITY_ARMOR_CONFIG,EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<ArmorItem> HYPHINITY_BOOTS = ITEMS.register("hyphinity_boots",
            () -> new ArmorItem(ModArmorTiers.HYPHINITY_ARMOR_CONFIG,EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));



    public static final RegistryObject<Item> HYPHINITY_SHARD = ITEMS.register("hyphinity_shard", HyphinityShard::new);


    //voiderous items
    public static final RegistryObject<Item> VOIDEROUS_STAFF = ITEMS.register("voiderous_staff", VoiderousStaff::new);


    //blocks
    public static final RegistryObject<Block> HYPERLANE_GEL_BLOCK = BLOCKS.register("hyperlane_gel_block", HyperlaneGelBlock::new);

    public static final RegistryObject<SlabBlock> HYPERLANE_GEL_SLAB = BLOCKS.register("hyperlane_gel_slab",
            () -> new SlabBlock(Block.Properties.from(RegistryHandler.HYPERLANE_GEL_BLOCK.get())));

    public static final RegistryObject<Block> HYPERLANE_GRAVEL = BLOCKS.register("hyperlane_gravel", HyperlaneGravel::new);

    public static final RegistryObject<Block> HYPERLANE_FURNACE = BLOCKS.register("hyperlane_furnace", HyperlaneFurnace::new);

    public static final RegistryObject<Block> HYPERLANE_STAFF_PEDESTAL = BLOCKS.register("hyperlane_staff_pedestal",
            () -> new HyperlaneStaffPedestalBlock(Block.Properties.from(Blocks.ANVIL)));

    public static final RegistryObject<Block> HYPHINITY_PLANKS = BLOCKS.register("hyphinity_planks",
            () -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> HYPHINITY_LOG = BLOCKS.register("hyphinity_log",
            () -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));

    public static final RegistryObject<Block> HYPHINITY_LEAVES = BLOCKS.register("hyphinity_leaves",
            () -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));

    public static final RegistryObject<Block> HYPHINITY_SAPLING = BLOCKS.register("hyphinity_sapling",
            () -> new HyphinitySapling(() -> new HyphinityTree(), Block.Properties.from(Blocks.OAK_SAPLING)));
    //hyphinity ores
    public static final RegistryObject<Block> HYPHINITY_ORE = BLOCKS.register("hyphinity_ore", HyphinityOre::new);
    public static final RegistryObject<Block> HYPHERIUM_BLOCK = BLOCKS.register("hypherium_block", HypheriumBlock::new);
    //Hyphinity fauna
    public static final RegistryObject<HyphinityFern> HYPHINITY_FERN = BLOCKS.register("hyphinity_fern",
            () -> new HyphinityFern(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)));

    public static final RegistryObject<HyphinityGrass> HYPHINITY_GRASS = BLOCKS.register("hyphinity_grass",
            () -> new HyphinityGrass(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)));

    public static final RegistryObject<HyphinityTallGrass> HYPHINITY_TALL_GRASS = BLOCKS.register("hyphinity_tall_grass",
            () -> new HyphinityTallGrass(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)));

    public static final RegistryObject<HyphinitySeaGrass> HYPHINITY_SEAGRASS = BLOCKS.register("hyphinity_seagrass",
            () -> new HyphinitySeaGrass(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)));

    public static final RegistryObject<HyphinityTallSeaGrass> HYPHINITY_TALL_SEAGRASS = BLOCKS.register("hyphinity_tall_seagrass",
            () -> new HyphinityTallSeaGrass(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)));

    public static final RegistryObject<HyphinityKelp> HYPHINITY_KELP = BLOCKS.register("hyphinity_kelp",
            () -> new HyphinityKelp(Block.Properties.create(Material.OCEAN_PLANT).tickRandomly().doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)));


    public static final RegistryObject<HyphinityKelpPlant> HYPHINITY_KELP_PLANT = BLOCKS.register("hyphinity_kelp_plant",
            () -> new HyphinityKelpPlant((HyphinityKelp)HYPHINITY_KELP.get(), Block.Properties.create(Material.OCEAN_PLANT).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.WET_GRASS)));

    public static final RegistryObject<HyphinityFlower> HYPHINITY_FLOWER = BLOCKS.register("hyphinity_flower",
            () -> new HyphinityFlower(Effects.POISON, 12, Block.Properties.create(Material.OCEAN_PLANT).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)));

    //hyphinity biome blocks
    public static final RegistryObject<HyphinitySoil> HYPHINITY_SOIL = BLOCKS.register("hyphinity_soil",
            () -> new HyphinitySoil(Block.Properties.create(Material.EARTH)));
    public static final RegistryObject<Block> HYPHINITY_GEL_BLOCK = BLOCKS.register("hyphinity_gel_block", HyphinityGelBlock::new);
    public static final RegistryObject<Block> HYPHINITY_STONE = BLOCKS.register("hyphinity_stone", HyphinityStone::new);


    //voiderous blocks
    public static final RegistryObject<Block> VOIDEROUS_MUCK = BLOCKS.register("voiderous_muck", VoiderousMuck::new);
    public static final RegistryObject<Block> VOIDEROUS_GRAVEL = BLOCKS.register("voiderous_gravel", VoiderousGravel::new);
    public static final RegistryObject<Block> VOIDEROUS_STONE = BLOCKS.register("voiderous_stone", VoiderousStone::new);
    public static final RegistryObject<Block> VOIDEROUS_DENSE_STONE = BLOCKS.register("voiderous_dense_stone", VoiderousDenseStone::new);

    public static final RegistryObject<Block> VOIDEROUS_LOG = BLOCKS.register("voiderous_log",
            () -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));


    public static final RegistryObject<Block> VOIDEROUS_TREE_BUILDER_BLOCK = BLOCKS.register("voiderous_tree_builder_block", VoiderousTreeBuilderBlock::new);
    //public static final RegistryObject<Block> VOIDEROUS_FIRE = BLOCKS.register("voiderous_fire", VoiderousFire::new);

//hyphinity block items
    public static final RegistryObject<Item> HYPERLANE_GEL_BLOCK_ITEM = ITEMS.register("hyperlane_gel_block", () -> new HyperlaneBlockItemBase(HYPERLANE_GEL_BLOCK.get()));
    public static final RegistryObject<Item> HYPERLANE_GEL_SLAB_ITEM = ITEMS.register("hyperlane_gel_slab", () -> new HyperlaneBlockItemBase(HYPERLANE_GEL_SLAB.get()));
    public static final RegistryObject<Item> HYPERLANE_GRAVEL_ITEM = ITEMS.register("hyperlane_gravel", () -> new HyperlaneBlockItemBase(HYPERLANE_GRAVEL.get()));
    public static final RegistryObject<Item> HYPERLANE_FURNACE_ITEM = ITEMS.register("hyperlane_furnace", () -> new HyperlaneBlockItemBase(HYPERLANE_FURNACE.get()));
    public static final RegistryObject<Item> HYPHINITY_ORE_ITEM = ITEMS.register("hyphinity_ore", () -> new HyperlaneBlockItemBase(HYPHINITY_ORE.get()));
    public static final RegistryObject<Item> HYPHERIUM_BLOCK_ITEM = ITEMS.register("hypherium_block", () -> new HyperlaneBlockItemBase(HYPHERIUM_BLOCK.get()));
    public static final RegistryObject<Item> HYPHINITY_FERN_ITEM = ITEMS.register("hyphinity_fern", () -> new HyperlaneBlockItemBase(HYPHINITY_FERN.get()));
    public static final RegistryObject<Item> HYPHINITY_GRASS_ITEM = ITEMS.register("hyphinity_grass", () -> new HyperlaneBlockItemBase(HYPHINITY_GRASS.get()));
    public static final RegistryObject<Item> HYPHINITY_TALL_GRASS_ITEM = ITEMS.register("hyphinity_tall_grass", () -> new HyperlaneBlockItemBase(HYPHINITY_TALL_GRASS.get()));
    public static final RegistryObject<Item> HYPHINITY_SEAGRASS_ITEM = ITEMS.register("hyphinity_seagrass", () -> new HyperlaneBlockItemBase(HYPHINITY_SEAGRASS.get()));
    public static final RegistryObject<Item> HYPHINITY_TALL_SEAGRASS_ITEM = ITEMS.register("hyphinity_tall_seagrass", () -> new HyperlaneBlockItemBase(HYPHINITY_TALL_SEAGRASS.get()));
    public static final RegistryObject<Item> HYPHINITY_KELP_ITEM = ITEMS.register("hyphinity_kelp", () -> new HyperlaneBlockItemBase(HYPHINITY_KELP.get()));
    public static final RegistryObject<Item> HYPHINITY_KELP_PLANT_ITEM = ITEMS.register("hyphinity_kelp_plant", () -> new HyperlaneBlockItemBase(HYPHINITY_KELP_PLANT.get()));
    public static final RegistryObject<Item> HYPHINITY_FLOWER_ITEM = ITEMS.register("hyphinity_flower", () -> new HyperlaneBlockItemBase(HYPHINITY_FLOWER.get()));
    public static final RegistryObject<Item> HYPHINITY_SOIL_ITEM = ITEMS.register("hyphinity_soil", () -> new HyperlaneBlockItemBase(HYPHINITY_SOIL.get()));
    public static final RegistryObject<Item> HYPHINITY_GEL_BLOCK_ITEM = ITEMS.register("hyphinity_gel_block", () -> new HyperlaneBlockItemBase(HYPHINITY_GEL_BLOCK.get()));
    public static final RegistryObject<Item> HYPHINITY_STONE_ITEM = ITEMS.register("hyphinity_stone", () -> new HyperlaneBlockItemBase(HYPHINITY_SOIL.get()));

//voiderous block items
    public static final RegistryObject<Item> VOIDEROUS_MUCK_ITEM = ITEMS.register("voiderous_muck", () -> new VoiderousBlockItemBase(VOIDEROUS_MUCK.get()));
    public static final RegistryObject<Item> VOIDEROUS_GRAVEL_ITEM = ITEMS.register("voiderous_gravel", () -> new VoiderousBlockItemBase(VOIDEROUS_GRAVEL.get()));
    public static final RegistryObject<Item> VOIDEROUS_STONE_ITEM = ITEMS.register("voiderous_stone", () -> new VoiderousBlockItemBase(VOIDEROUS_STONE.get()));
    public static final RegistryObject<Item> VOIDEROUS_DENSE_STONE_ITEM = ITEMS.register("voiderous_dense_stone", () -> new VoiderousBlockItemBase(VOIDEROUS_DENSE_STONE.get()));
    public static final RegistryObject<Item> VOIDEROUS_LOG_ITEM = ITEMS.register("voiderous_log", () -> new VoiderousBlockItemBase(VOIDEROUS_LOG.get()));
    public static final RegistryObject<Item> VOIDEROUS_TREE_BUILDER_BLOCK_ITEM = ITEMS.register("voiderous_tree_builder_block", () -> new VoiderousBlockItemBase(VOIDEROUS_TREE_BUILDER_BLOCK.get()));




    //hyperlane hyphinity  BLOCK items
    public static final RegistryObject<Item> HYPHINITY_PLANKS_ITEM = ITEMS.register("hyphinity_planks", () -> new HyperlaneBlockItemBase(HYPHINITY_PLANKS.get()));
    public static final RegistryObject<Item> HYPHINITY_LOG_ITEM = ITEMS.register("hyphinity_log", () -> new HyperlaneBlockItemBase(HYPHINITY_LOG.get()));
    public static final RegistryObject<Item> HYPHINITY_LEAVES_ITEM = ITEMS.register("hyphinity_leaves", () -> new HyperlaneBlockItemBase(HYPHINITY_LEAVES.get()));
    public static final RegistryObject<Item> HYPHINITY_SAPLING_ITEM = ITEMS.register("hyphinity_sapling", () -> new HyperlaneBlockItemBase(HYPHINITY_SAPLING.get()));
    public static final RegistryObject<Item> HYPERLANE_STAFF_PEDESTAL_ITEM = ITEMS.register("hyperlane_staff_pedestal", () -> new HyperlaneBlockItemBase(HYPERLANE_STAFF_PEDESTAL.get()));


    //features

    public static final RegistryObject<HyphinitySeaGrassFeature> HYPHINITY_SEAGRASS_FEATURE = FEATURE_TYPES.register("hyphinity_seagrass_feature", () -> new HyphinitySeaGrassFeature(HyphinitySeaGrassFeatureConfig::deserialize));



    //entities
        public static final RegistryObject<EntityType<HyperlanePhantom>> HYPERLANE_PHANTOM = ENTITY_TYPES
            .register("hyperlane_phantom",
                    () -> EntityType.Builder.<HyperlanePhantom>create(HyperlanePhantom::new, EntityClassification.CREATURE)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(Hyperlane.MOD_ID, "hyperlane_phantom").toString()));

    public static final RegistryObject<EntityType<HyphinityWisp>> HYPHINITY_WISP = ENTITY_TYPES
            .register("hyphinity_wisp",
                    () -> EntityType.Builder.<HyphinityWisp>create(HyphinityWisp::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(Hyperlane.MOD_ID, "hyphinity_wisp").toString()));

    public static final RegistryObject<EntityType<HyphinitySwoop>> HYPHINITY_SWOOP = ENTITY_TYPES
            .register("hyphinity_swoop",
                    () -> EntityType.Builder.<HyphinitySwoop>create(HyphinitySwoop::new, EntityClassification.MONSTER)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(Hyperlane.MOD_ID, "hyphinity_swoop").toString()));



    //tile entities

    public static final RegistryObject<TileEntityType<HyperlaneFurnaceTileEntity>> HYPERLANE_FURNACE_TILE_ENTITY = TILE_ENTITY_TYPES
            .register("hyperlane_furnace", () -> TileEntityType.Builder
                    .create(HyperlaneFurnaceTileEntity::new, RegistryHandler.HYPERLANE_FURNACE.get()).build(null));

    public static final RegistryObject<TileEntityType<HyperlaneStaffPedestalTileEntity>> HYPERLANE_STAFF_PEDESTAL_TILE_ENTITY = TILE_ENTITY_TYPES
            .register("hyperlane_staff_pedestal", () -> TileEntityType.Builder
                    .create(HyperlaneStaffPedestalTileEntity::new, RegistryHandler.HYPERLANE_STAFF_PEDESTAL.get()).build(null));


    public static final RegistryObject<TileEntityType<VoiderousTreeBuilderBlockTileEntity>> VOIDEROUS_TREE_BUILDER_BLOCK_TILE_ENTITY = TILE_ENTITY_TYPES
            .register("voiderous_tree_builder_block", () -> TileEntityType.Builder
                    .create(VoiderousTreeBuilderBlockTileEntity::new, RegistryHandler.VOIDEROUS_TREE_BUILDER_BLOCK.get()).build(null));



    //containers

    public static final RegistryObject<ContainerType<HyperlaneFurnaceContainer>> HYPERLANE_FURNACE_CONTAINER = CONTAINER_TYPE_DEFERRED_REGISTER
            .register("hyperlane_furance_container", () -> IForgeContainerType.create(HyperlaneFurnaceContainer::new));

    public static final RegistryObject<ContainerType<HyperlaneStaffPedestalContainer>> HYPERLANE_STAFF_PEDESTAL_CONTAINER = CONTAINER_TYPE_DEFERRED_REGISTER
            .register("hyperlane_staff_pedestal", () -> IForgeContainerType.create(HyperlaneStaffPedestalContainer::new));

//    public static final RegistryObject<ContainerType<DimensionalBridgeBuilderContainer>> DIMENSIONAL_BRIDGE_BUILDER_CONTAINER = CONTAINER_TYPE_DEFERRED_REGISTER
//            .register("dimensional_bridge_builder", () -> IForgeContainerType.create(DimensionalBridgeBuilderContainer::new));



    public static void registerEntityWorldSpawn(EntityType<?> entity, int weight, int minGroupIn, int maxGroupIn, Biome... biomes) {
        for(Biome biome : biomes) {
            if (biome != null) {
                biome.getSpawns(entity.getClassification()).add(new Biome.SpawnListEntry(entity, weight, minGroupIn, maxGroupIn));
            }
        }

    }


    //biomes
    public static final RegistryObject<Biome> HYPERLANE_DRIFTS = BIOMES.register("hyperlane_drifts",
            () -> new HyperlaneDrifts(new Biome.Builder().precipitation(Biome.RainType.SNOW).scale(1.2f).temperature(0.5f)
                    .waterColor(16777215).waterFogColor(16777215)
                    .surfaceBuilder(HyperlaneDriftsSurfaceBuilder.DEFAULT,
                            new SurfaceBuilderConfig(
                                    RegistryHandler.HYPERLANE_GEL_BLOCK.get().getDefaultState(),
                                    RegistryHandler.HYPERLANE_GRAVEL.get().getDefaultState(),
                                    RegistryHandler.HYPERLANE_GEL_BLOCK.get().getDefaultState()))
                    .category(Biome.Category.ICY)
                    .downfall(0.5f)

                    .depth(0.12f)
                    .parent(null)

            ));

    public static final RegistryObject<Biome> HYPHINITY_LIMBO = BIOMES.register("hyphinity_oasis",
            () -> new HyphinityLimbo(new Biome.Builder().precipitation(Biome.RainType.SNOW).scale(1.2f).temperature(0.5f)
                    .waterColor(16777215).waterFogColor(16777215)
                    .surfaceBuilder(HyperlaneDriftsSurfaceBuilder.DEFAULT,
                            new SurfaceBuilderConfig(
                                    RegistryHandler.HYPHINITY_GEL_BLOCK.get().getDefaultState(),
                                    RegistryHandler.HYPHINITY_SOIL.get().getDefaultState(),
                                    RegistryHandler.HYPHINITY_GEL_BLOCK.get().getDefaultState()))
                    .category(Biome.Category.ICY)
                    .downfall(0.5f)
                    .depth(0.12f)
                    .parent(null)

            ));

    public static final RegistryObject<Biome> VOIDEROUS_NIGHTMARE = BIOMES.register("voiderous_nightmare",
            () -> new VoiderousNightmare(new Biome.Builder().precipitation(Biome.RainType.NONE).scale(1.2f).temperature(2f)
                    .waterColor(14205695).waterFogColor(11103743)
                    .surfaceBuilder(HyperlaneDriftsSurfaceBuilder.DEFAULT,
                            new SurfaceBuilderConfig(
                                    RegistryHandler.VOIDEROUS_GRAVEL.get().getDefaultState(),
                                    RegistryHandler.VOIDEROUS_STONE.get().getDefaultState(),
                                    RegistryHandler.VOIDEROUS_STONE.get().getDefaultState()))
                    .category(Biome.Category.MESA)
                    .downfall(0.5f)
                    .depth(0.12f)
                    .parent(null)

            ));

    public static final RegistryObject<Biome> VOIDEROUS_HELL = BIOMES.register("voiderous_hell",
            () -> new VoiderousHell(new Biome.Builder().precipitation(Biome.RainType.NONE).scale(.4f).temperature(2f)
                    .waterColor(14205695).waterFogColor(11103743)
                    .surfaceBuilder(HyperlaneDriftsSurfaceBuilder.DEFAULT,
                            new SurfaceBuilderConfig(
                                    RegistryHandler.VOIDEROUS_GRAVEL.get().getDefaultState(),
                                    RegistryHandler.VOIDEROUS_STONE.get().getDefaultState(),
                                    RegistryHandler.VOIDEROUS_STONE.get().getDefaultState()))
                    .category(Biome.Category.MESA)
                    .downfall(0.5f)
                    .depth(0.12f)
                    .parent(null)

            ));


    public static void registerBiomes(){


        registerBiome(HYPERLANE_DRIFTS.get(), BiomeDictionary.Type.COLD, BiomeDictionary.Type.OVERWORLD);
    }

    public static void registerBiome(Biome biome, BiomeDictionary.Type... types) {
        if (biome == RegistryHandler.HYPERLANE_DRIFTS.get() ) {
            BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(biome, 100));
        }
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }

    //dimensions
    public static final DeferredRegister<ModDimension> MOD_DIMENSIONS = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, Hyperlane.MOD_ID);

    public static final RegistryObject<ModDimension> HYPERLANE_DIM = MOD_DIMENSIONS.register("hyperlane_dim", () -> new HyperlaneModDimension());
    public static final RegistryObject<ModDimension> HYPHINITY_DIM = MOD_DIMENSIONS.register("hyphinity_dim", () -> new HyphinityModDimension());
    public static final RegistryObject<ModDimension> VEOMESHED_DIM = MOD_DIMENSIONS.register("veomeshed_dim", () -> new VeomeshedModDimension());
    public static final RegistryObject<ModDimension> VOIDEROUS_DIM = MOD_DIMENSIONS.register("voiderous_dim", () -> new VoiderousModDimension());


}


