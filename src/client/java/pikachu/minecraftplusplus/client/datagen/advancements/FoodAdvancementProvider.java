package pikachu.minecraftplusplus.client.datagen.advancements;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.criterion.*;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import static pikachu.minecraftplusplus.MinecraftPlusPlus.MOD_ID;

public class FoodAdvancementProvider extends FabricAdvancementProvider {
    public FoodAdvancementProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(HolderLookup.Provider registryLookup, Consumer<AdvancementHolder> consumer) {
        final HolderLookup.RegistryLookup<Item> itemLookup = registryLookup.lookupOrThrow(Registries.ITEM);

        // Root of the statistics tab - obtain a crafting table
        AdvancementHolder foodRoot = Advancement.Builder.advancement()
                .display(
                        Items.HAY_BLOCK,
                        Component.literal("Food"),
                        Component.literal("Tasty snack!"),
                        Identifier.fromNamespaceAndPath("minecraftplusplus", "gui/advancements/backgrounds/hay_block_side"),
                        AdvancementType.TASK,
                        false,
                        false,
                        false
                )
                .addCriterion("food_root", ConsumeItemTrigger.TriggerInstance.usedItem())
                .save(consumer, Identifier.fromNamespaceAndPath(MOD_ID, "food_root"));

        // Eat an apple
        AdvancementHolder eatApple = Advancement.Builder.advancement()
                .display(
                        Items.APPLE,
                        Component.literal("How Do You Like Them Apples?"),
                        Component.literal("Eat an apple"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("eat_apple", ConsumeItemTrigger.TriggerInstance.usedItem(itemLookup, Items.APPLE))
                .save(consumer, Identifier.fromNamespaceAndPath(MOD_ID, "eat_apple"));


    }
}
