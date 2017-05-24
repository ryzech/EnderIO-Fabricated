package crazypants.enderio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.enderio.core.common.util.NullHelper;

import crazypants.enderio.block.coldfire.BlockColdFire;
import crazypants.enderio.block.darksteel.anvil.BlockDarkSteelAnvil;
import crazypants.enderio.block.darksteel.bars.BlockDarkIronBars;
import crazypants.enderio.block.darksteel.ladder.BlockDarkSteelLadder;
import crazypants.enderio.block.darksteel.obsidian.BlockReinforcedObsidian;
import crazypants.enderio.block.darksteel.trapdoor.BlockDarkSteelTrapDoor;
import crazypants.enderio.block.decoration.BlockDecoration;
import crazypants.enderio.block.decoration.BlockDecorationFacing;
import crazypants.enderio.block.detector.BlockDetector;
import crazypants.enderio.block.lever.BlockSelfResettingLever;
import crazypants.enderio.block.painted.BlockPaintedCarpet;
import crazypants.enderio.block.painted.BlockPaintedFence;
import crazypants.enderio.block.painted.BlockPaintedFenceGate;
import crazypants.enderio.block.painted.BlockPaintedGlowstone;
import crazypants.enderio.block.painted.BlockPaintedPressurePlate;
import crazypants.enderio.block.painted.BlockPaintedRedstone;
import crazypants.enderio.block.painted.BlockPaintedSlab;
import crazypants.enderio.block.painted.BlockPaintedStairs;
import crazypants.enderio.block.painted.BlockPaintedStone;
import crazypants.enderio.block.painted.BlockPaintedTrapDoor;
import crazypants.enderio.block.painted.BlockPaintedWall;
import crazypants.enderio.block.rail.BlockExitRail;
import crazypants.enderio.capacitor.ItemCapacitor;
import crazypants.enderio.conduit.BlockConduitBundle;
import crazypants.enderio.conduit.facade.ItemConduitFacade;
import crazypants.enderio.conduit.item.ItemExtractSpeedUpgrade;
import crazypants.enderio.conduit.item.ItemFunctionUpgrade;
import crazypants.enderio.conduit.item.ItemItemConduit;
import crazypants.enderio.conduit.item.filter.ItemBasicItemFilter;
import crazypants.enderio.conduit.item.filter.ItemExistingItemFilter;
import crazypants.enderio.conduit.item.filter.ItemModItemFilter;
import crazypants.enderio.conduit.item.filter.ItemPowerItemFilter;
import crazypants.enderio.conduit.item.filter.ItemSpeciesItemFilter;
import crazypants.enderio.conduit.liquid.ItemLiquidConduit;
import crazypants.enderio.conduit.me.ItemMEConduit;
import crazypants.enderio.conduit.oc.ItemOCConduit;
import crazypants.enderio.conduit.power.ItemPowerConduit;
import crazypants.enderio.conduit.redstone.ItemRedstoneConduit;
import crazypants.enderio.farming.BlockFarmStation;
import crazypants.enderio.item.coldfire.ItemColdFireIgniter;
import crazypants.enderio.item.conduitprobe.ItemConduitProbe;
import crazypants.enderio.item.darksteel.ItemDarkSteelArmor;
import crazypants.enderio.item.darksteel.ItemDarkSteelAxe;
import crazypants.enderio.item.darksteel.ItemDarkSteelBow;
import crazypants.enderio.item.darksteel.ItemDarkSteelPickaxe;
import crazypants.enderio.item.darksteel.ItemDarkSteelShears;
import crazypants.enderio.item.darksteel.ItemDarkSteelSword;
import crazypants.enderio.item.darksteel.ItemGliderWing;
import crazypants.enderio.item.enderface.ItemEnderface;
import crazypants.enderio.item.magnet.ItemMagnet;
import crazypants.enderio.item.skull.BlockEndermanSkull;
import crazypants.enderio.item.soulvial.ItemSoulVessel;
import crazypants.enderio.item.yetawrench.ItemYetaWrench;
import crazypants.enderio.machine.buffer.BlockBuffer;
import crazypants.enderio.machine.capbank.BlockCapBank;
import crazypants.enderio.machine.crafter.BlockCrafter;
import crazypants.enderio.machine.enchanter.BlockEnchanter;
import crazypants.enderio.machine.gauge.BlockGauge;
import crazypants.enderio.machine.generator.combustion.BlockCombustionGenerator;
import crazypants.enderio.machine.generator.stirling.BlockStirlingGenerator;
import crazypants.enderio.machine.generator.zombie.BlockZombieGenerator;
import crazypants.enderio.machine.invpanel.BlockInventoryPanel;
import crazypants.enderio.machine.invpanel.chest.BlockInventoryChest;
import crazypants.enderio.machine.invpanel.remote.ItemRemoteInvAccess;
import crazypants.enderio.machine.invpanel.sensor.BlockInventoryPanelSensor;
import crazypants.enderio.machine.killera.BlockKillerJoe;
import crazypants.enderio.machine.light.BlockElectricLight;
import crazypants.enderio.machine.light.BlockLightNode;
import crazypants.enderio.machine.monitor.BlockPowerMonitor;
import crazypants.enderio.machine.obelisk.attractor.BlockAttractor;
import crazypants.enderio.machine.obelisk.aversion.BlockAversionObelisk;
import crazypants.enderio.machine.obelisk.inhibitor.BlockInhibitorObelisk;
import crazypants.enderio.machine.obelisk.relocator.BlockRelocatorObelisk;
import crazypants.enderio.machine.obelisk.weather.BlockWeatherObelisk;
import crazypants.enderio.machine.obelisk.xp.BlockExperienceObelisk;
import crazypants.enderio.machine.obelisk.xp.ItemXpTransfer;
import crazypants.enderio.machine.painter.BlockPainter;
import crazypants.enderio.machine.reservoir.BlockReservoir;
import crazypants.enderio.machine.solar.BlockSolarPanel;
import crazypants.enderio.machine.tank.BlockTank;
import crazypants.enderio.machine.vacuum.BlockVacuumChest;
import crazypants.enderio.machine.vacuum.BlockXPVacuum;
import crazypants.enderio.material.alloy.BlockAlloy;
import crazypants.enderio.material.alloy.ItemAlloy;
import crazypants.enderio.material.food.ItemEnderFood;
import crazypants.enderio.material.glass.BlockFusedQuartz;
import crazypants.enderio.material.glass.BlockPaintedFusedQuartz;
import crazypants.enderio.material.material.ItemMaterial;
import crazypants.enderio.power.wireless.BlockWirelessCharger;
import crazypants.enderio.recipe.alloysmelter.BlockAlloySmelter;
import crazypants.enderio.recipe.sagmill.BlockSagMill;
import crazypants.enderio.recipe.slicensplice.BlockSliceAndSplice;
import crazypants.enderio.recipe.soul.BlockSoulBinder;
import crazypants.enderio.recipe.spawner.BlockPoweredSpawner;
import crazypants.enderio.recipe.spawner.ItemBrokenSpawner;
import crazypants.enderio.recipe.vat.BlockVat;
import crazypants.enderio.render.dummy.BlockMachineBase;
import crazypants.enderio.render.dummy.BlockMachineIO;
import crazypants.enderio.teleport.ItemTravelStaff;
import crazypants.enderio.teleport.anchor.BlockTravelAnchor;
import crazypants.enderio.teleport.telepad.BlockDialingDevice;
import crazypants.enderio.teleport.telepad.BlockTelePad;
import crazypants.enderio.teleport.telepad.ItemCoordSelector;
import crazypants.enderio.teleport.telepad.ItemLocationPrintout;
import crazypants.enderio.teleport.telepad.ItemRodOfReturn;
import crazypants.enderio.transceiver.BlockTransceiver;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public enum ModObject implements IModObject {

  block_machine_io(BlockMachineIO.class),
  block_machine_base(BlockMachineBase.class),

  // Enderface
  itemEnderface(ItemEnderface.class),

  // Conduits
  blockConduitBundle(BlockConduitBundle.class),
  itemConduitFacade(ItemConduitFacade.class),
  itemRedstoneConduit(ItemRedstoneConduit.class),
  itemItemConduit(ItemItemConduit.class),
  itemGasConduit,
  itemMEConduit(ItemMEConduit.class),
  itemOCConduit(ItemOCConduit.class),
  itemBasicFilterUpgrade(ItemBasicItemFilter.class),
  itemExistingItemFilter(ItemExistingItemFilter.class),
  itemModItemFilter(ItemModItemFilter.class),
  itemPowerItemFilter(ItemPowerItemFilter.class),
  itemSpeciesItemFilter(ItemSpeciesItemFilter.class) {
    @Override
    protected void preInitElem(@Nonnull FMLPreInitializationEvent event) {
      if (Loader.isModLoaded("forestry")) {
        super.preInitElem(event);
      }
    }
  },
  itemExtractSpeedUpgrade(ItemExtractSpeedUpgrade.class),
  itemFunctionUpgrade(ItemFunctionUpgrade.class),

  // Power
  itemPowerConduit(ItemPowerConduit.class),

  // Liquid
  itemLiquidConduit(ItemLiquidConduit.class),

  // Materials
  itemBasicCapacitor(ItemCapacitor.class),
  blockAlloy(BlockAlloy.class),
  itemAlloyIngot(ItemAlloy.class),
  itemAlloyNugget(ItemAlloy.class, "createNuggets"),
  itemMaterial(ItemMaterial.class),

  // Machines
  blockStirlingGenerator(BlockStirlingGenerator.class),
  blockCombustionGenerator(BlockCombustionGenerator.class),
  blockZombieGenerator(BlockZombieGenerator.class),
  blockReservoir(BlockReservoir.class),
  blockAlloySmelter(BlockAlloySmelter.class),
  blockSolarPanel(BlockSolarPanel.class),
  blockCapBank(BlockCapBank.class),
  blockSagMill(BlockSagMill.class),
  blockPowerMonitor(BlockPowerMonitor.class, "createPowerMonitor"),
  blockPowerMonitorv2(BlockPowerMonitor.class, "createAdvancedPowerMonitor"),
  blockVat(BlockVat.class),
  blockFarmStation(BlockFarmStation.class),
  blockTank(BlockTank.class),
  blockCrafter(BlockCrafter.class),
  blockVacuumChest(BlockVacuumChest.class),
  blockXPVacuum(BlockXPVacuum.class),
  blockWirelessCharger(BlockWirelessCharger.class),
  blockEnchanter(BlockEnchanter.class),
  blockSoulBinder(BlockSoulBinder.class),
  blockSliceAndSplice(BlockSliceAndSplice.class),
  blockAttractor(BlockAttractor.class),
  blockSpawnGuard(BlockAversionObelisk.class),
  blockSpawnRelocator(BlockRelocatorObelisk.class),
  blockExperienceObelisk(BlockExperienceObelisk.class),
  blockWeatherObelisk(BlockWeatherObelisk.class),
  blockInhibitorObelisk(BlockInhibitorObelisk.class),
  blockTransceiver(BlockTransceiver.class),
  blockBuffer(BlockBuffer.class),
  blockInventoryPanel(BlockInventoryPanel.class),
  blockInventoryChest(BlockInventoryChest.class),

  blockPoweredSpawner(BlockPoweredSpawner.class),
  itemBrokenSpawner(ItemBrokenSpawner.class),
  blockKillerJoe(BlockKillerJoe.class),

  blockElectricLight(BlockElectricLight.class),
  blockLightNode(BlockLightNode.class),

  //Blocks
  blockColdFire(BlockColdFire.class),
  blockDarkSteelAnvil(BlockDarkSteelAnvil.class),
  blockDarkSteelLadder(BlockDarkSteelLadder.class),
  blockDarkIronBars(BlockDarkIronBars.class),
  blockDarkSteelTrapdoor(BlockDarkSteelTrapDoor.class),
  blockReinforcedObsidian(BlockReinforcedObsidian.class),
  blockSelfResettingLever10(BlockSelfResettingLever.class, "create10"),
  blockSelfResettingLever30(BlockSelfResettingLever.class, "create30"),
  blockSelfResettingLever60(BlockSelfResettingLever.class, "create60"),
  blockSelfResettingLever300(BlockSelfResettingLever.class, "create300"),
  blockDecoration1(BlockDecoration.class),
  blockDecoration2(BlockDecorationFacing.class),

  // Painter
  blockPainter(BlockPainter.class),
  blockPaintedFence(BlockPaintedFence.class),
  blockPaintedStoneFence(BlockPaintedFence.class, "create_stone"),
  blockPaintedFenceGate(BlockPaintedFenceGate.class),
  blockPaintedWall(BlockPaintedWall.class),
  blockPaintedStair(BlockPaintedStairs.class),
  blockPaintedStoneStair(BlockPaintedStairs.class, "create_stone"),
  blockPaintedSlab {
    @Override
    protected void preInitElem(@Nonnull FMLPreInitializationEvent event) {
      BlockPaintedSlab[] slabs = BlockPaintedSlab.create();
      block = slabs[0];
      item = Item.getItemFromBlock(NullHelper.notnull(slabs[0], "BlockPaintedSlab failed to create"));
      blockPaintedDoubleSlab.block = slabs[1];
      blockPaintedDoubleSlab.item = Item.getItemFromBlock(NullHelper.notnull(slabs[1], "BlockPaintedSlab failed to create"));
      blockPaintedStoneSlab.block = slabs[2];
      blockPaintedStoneSlab.item = Item.getItemFromBlock(NullHelper.notnull(slabs[2], "BlockPaintedSlab failed to create"));
      blockPaintedStoneDoubleSlab.block = slabs[3];
      blockPaintedStoneDoubleSlab.item = Item.getItemFromBlock(NullHelper.notnull(slabs[3], "BlockPaintedSlab failed to create"));
    }
  },
  blockPaintedDoubleSlab {
    @Override
    protected void preInitElem(@Nonnull FMLPreInitializationEvent event) {
      // see blockPaintedSlab
    }
  },
  blockPaintedStoneSlab {
    @Override
    protected void preInitElem(@Nonnull FMLPreInitializationEvent event) {
      // see blockPaintedSlab
    }
  },
  blockPaintedStoneDoubleSlab {
    @Override
    protected void preInitElem(@Nonnull FMLPreInitializationEvent event) {
      // see blockPaintedSlab
    }
  },
  blockPaintedGlowstone(BlockPaintedGlowstone.class),
  blockPaintedGlowstoneSolid(BlockPaintedGlowstone.class, "create_solid"),
  blockPaintedCarpet(BlockPaintedCarpet.class),
  blockPaintedPressurePlate(BlockPaintedPressurePlate.class),
  blockPaintedRedstone(BlockPaintedRedstone.class),
  blockPaintedRedstoneSolid,
  blockPaintedStone(BlockPaintedStone.class),
  blockPaintedWoodenTrapdoor(BlockPaintedTrapDoor.class, "create_wooden"),
  blockPaintedIronTrapdoor(BlockPaintedTrapDoor.class, "create_iron"),
  blockPaintedDarkSteelTrapdoor(BlockPaintedTrapDoor.class, "create_dark"),

  blockExitRail(BlockExitRail.class),

  itemConduitProbe(ItemConduitProbe.class),
  itemYetaWrench(ItemYetaWrench.class),
  itemXpTransfer(ItemXpTransfer.class),
  itemColdFireIgniter(ItemColdFireIgniter.class),

  blockTravelAnchor(BlockTravelAnchor.class),
  blockTelePad(BlockTelePad.class, "createTelepad"),
  blockDialingDevice(BlockDialingDevice.class),
  itemCoordSelector(ItemCoordSelector.class),
  itemLocationPrintout(ItemLocationPrintout.class),
  itemTravelStaff(ItemTravelStaff.class),
  itemRodOfReturn(ItemRodOfReturn.class),
  itemMagnet(ItemMagnet.class),
  itemGliderWing(ItemGliderWing.class),
  blockEndermanSkull(BlockEndermanSkull.class),
  itemEnderFood(ItemEnderFood.class),
  blockGauge(BlockGauge.class),
  itemRemoteInvAccess(ItemRemoteInvAccess.class),
  blockInventoryPanelSensor(BlockInventoryPanelSensor.class),

  blockFusedQuartz(BlockFusedQuartz.class, "createFusedQuartz"),
  blockFusedGlass(BlockFusedQuartz.class, "createFusedGlass"),
  blockEnlightenedFusedQuartz(BlockFusedQuartz.class, "createEnlightenedFusedQuartz"),
  blockEnlightenedFusedGlass(BlockFusedQuartz.class, "createEnlightenedFusedGlass"),
  blockDarkFusedQuartz(BlockFusedQuartz.class, "createDarkFusedQuartz"),
  blockDarkFusedGlass(BlockFusedQuartz.class, "createDarkFusedGlass"),
  blockPaintedFusedQuartz(BlockPaintedFusedQuartz.class),

  itemSoulVessel(ItemSoulVessel.class) {
    @Override
    protected void initElem(@Nonnull FMLInitializationEvent event) {
      ItemSoulVessel.initPhase();
    }
  },

  block_detector_block(BlockDetector.class),
  block_detector_block_silent(BlockDetector.class, "createSilent"),

  itemDarkSteelHelmet(ItemDarkSteelArmor.class, "createDarkSteelHelmet"),
  itemDarkSteelChestplate(ItemDarkSteelArmor.class, "createDarkSteelChestplate"),
  itemDarkSteelLeggings(ItemDarkSteelArmor.class, "createDarkSteelLeggings"),
  itemDarkSteelBoots(ItemDarkSteelArmor.class, "createDarkSteelBoots"),
  itemDarkSteelSword(ItemDarkSteelSword.class),
  itemDarkSteelPickaxe(ItemDarkSteelPickaxe.class),
  itemDarkSteelAxe(ItemDarkSteelAxe.class),
  itemDarkSteelBow(ItemDarkSteelBow.class),
  itemDarkSteelShears(ItemDarkSteelShears.class),

  ;

  private final @Nonnull String unlocalisedName;

  protected @Nullable Block block;
  protected @Nullable Item item;
  
  protected final @Nullable Class<?> clazz;
  protected final @Nonnull String methodName;
  protected final @Nullable Class<? extends TileEntity> teClazz;
  
  private ModObject() {
    this(null);
  }

  private ModObject(@Nullable Class<?> clazz) {
    this(clazz, "create", null);
  }

  private ModObject(@Nullable Class<?> clazz, Class<? extends TileEntity> teClazz) {
    this(clazz, "create", teClazz);
  }
  
  private ModObject(@Nullable Class<?> clazz, @Nonnull String methodName) {
    this(clazz, methodName, null);
  }

  private ModObject(@Nullable Class<?> clazz, @Nonnull String methodName, Class<? extends TileEntity> teClazz) {
    unlocalisedName = NullHelper.notnullJ(name().replaceAll("([A-Z])", "_$0").toLowerCase(Locale.ENGLISH), "Enum.name()");
    this.clazz = clazz;
    this.methodName = methodName;
    this.teClazz = teClazz;
  }
  
  @Override
  public @Nonnull String getUnlocalisedName() {
    return unlocalisedName;
  }

  @Override
  public @Nullable Block getBlock() {
    return block;
  }

  @Override
  public @Nullable Item getItem() {
    return item;
  }

  public @Nonnull Block getBlockNN() {
    return NullHelper.notnull(block, "Block " + this + " is unexpectedly missing");
  }

  public @Nonnull Item getItemNN() {
    return NullHelper.notnull(item, "Item " + this + " is unexpectedly missing");
  }

  protected void preInitElem(@Nonnull FMLPreInitializationEvent event) {
    final Class<?> clazz2 = clazz; // because final fields may unexpectedly become null, according to our compiler warnings
    if (clazz2 == null) {
      Log.debug(this + ".preInitElem() missing");
      return;
    }
    Object obj = null;
    try {
      obj = clazz2.getDeclaredMethod(methodName, new Class<?>[] { IModObject.class }).invoke(null, new Object[] { this });
    } catch (Throwable e) {
      String str = "ModObject:create: Could not create instance for " + clazz + " using method " + methodName;
      Log.error(str + " Exception: " + e);
      throw new RuntimeException(str, e);
    }
    if (obj instanceof Item) {
      item = (Item)obj;
    } else if (obj instanceof Block) {
      block = (Block)obj;
      item = Item.getItemFromBlock(block);
      if (block instanceof BlockEio<?>) {
        ((BlockEio<?>) block).preInit(event);
      }
    }
  }

  protected void initElem(@Nonnull FMLInitializationEvent event) {
    if (block instanceof BlockEio<?>) {
      ((BlockEio<?>) block).init(event);
    }
  }

  private static void registerTeClasses() {
    Map<Class<? extends TileEntity>, List<String>> clazzes = new HashMap<Class<? extends TileEntity>, List<String>>();

    for (ModObject elem : values()) {
      if (elem.teClazz != null) {
        if (!clazzes.containsKey(elem.teClazz)) {
          clazzes.put(elem.teClazz, new ArrayList<String>());
        }
        clazzes.get(elem.teClazz).add(elem.unlocalisedName + "_tile_entity");
      }
    }

    for (Entry<Class<? extends TileEntity>, List<String>> entry : clazzes.entrySet()) {
      if (entry.getValue().size() == 1) {
        GameRegistry.registerTileEntity(entry.getKey(), entry.getValue().get(0));
      } else {
        Collections.sort(entry.getValue());
        String[] params = new String[entry.getValue().size() - 1];
        for (int i = 0; i < params.length; i++) {
          params[i] = entry.getValue().get(i + 1);
        }
        GameRegistry.registerTileEntityWithAlternatives(entry.getKey(), entry.getValue().get(0), params);
      }
    }
  }

  public static void init(@Nonnull FMLPreInitializationEvent event) {
    for (ModObject elem : values()) {
      elem.preInitElem(event);
    }
    registerTeClasses();
  }

  public static void init(@Nonnull FMLInitializationEvent event) {
    for (ModObject elem : values()) {
      elem.initElem(event);
    }
  }

}
