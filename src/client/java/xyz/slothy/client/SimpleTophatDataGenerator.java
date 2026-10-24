package xyz.slothy.client;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import org.jspecify.annotations.NonNull;
import xyz.slothy.client.model.SimpleTophatModelProvider;
import xyz.slothy.client.recipe.SimpleTophatRecipeProvider;

public class SimpleTophatDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(@NonNull FabricDataGenerator dataGenerator) {
		FabricDataGenerator.Pack pack = dataGenerator.createPack();
		pack.addProvider(SimpleTophatModelProvider::new);
		pack.addProvider(SimpleTophatRecipeProvider::new);
	}
}
