package pikachu.minecraftplusplus.client.datagen.advancements;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.fabricmc.fabric.mixin.event.interaction.PlayerAdvancementsMixin;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.advancements.criterion.PlayerTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.stats.Stat;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.PlayerRideable;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.WorldDataConfiguration;
import net.minecraft.world.level.storage.PlayerDataStorage;
import net.minecraft.world.level.storage.WorldData;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import static pikachu.minecraftplusplus.MinecraftPlusPlus.MOD_ID;

/**
 * Contains custom advancements that will be added to the vanilla "Minecraft" tab
 */
public class StatisticsAdvancementProvider extends FabricAdvancementProvider {
    public StatisticsAdvancementProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(HolderLookup.Provider registryLookup, Consumer<AdvancementHolder> consumer) {

        // Root of the statistics tab - obtain a crafting table
        AdvancementHolder statisticsRoot = Advancement.Builder.advancement()
                .display(
                        Items.PAPER,
                        Component.literal("Statistics"),
                        Component.literal("Number go up!"),
                        Identifier.fromNamespaceAndPath("minecraftplusplus", "gui/advancements/backgrounds/diamond_block"),
                        AdvancementType.TASK,
                        false,
                        false,
                        false
                )
                .addCriterion("statistics_root", InventoryChangeTrigger.TriggerInstance.hasItems(Items.CRAFTING_TABLE))
                .save(consumer, Identifier.fromNamespaceAndPath(MOD_ID, "statistics_root"));

//        AdvancmentHolder boatHalfKm = Advancement.Builder.advancement()
//                .parent(statisticsRoot)
//                .display(
//                        Items.OAK_BOAT,
//                        Component.literal("Novice Boater"),
//                        Component.literal("Travel 500m in a boat"),
//                        null,
//                        AdvancementType.TASK,
//                        true,
//                        true,
//                        false
//                )
//                .addCriterion("boat_half_km")
    }
}
