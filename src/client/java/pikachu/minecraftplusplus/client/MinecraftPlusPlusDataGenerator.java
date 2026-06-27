package pikachu.minecraftplusplus.client;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import pikachu.minecraftplusplus.client.datagen.advancements.StatisticsAdvancementProvider;

public class MinecraftPlusPlusDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(StatisticsAdvancementProvider::new);
	}
}
