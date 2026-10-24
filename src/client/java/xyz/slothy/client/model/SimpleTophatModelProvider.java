package xyz.slothy.client.model;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.color.item.Dye;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ItemModelUtils;
import org.jspecify.annotations.NonNull;
import xyz.slothy.SimpleTophat;
import xyz.slothy.item.ModItems;

public class SimpleTophatModelProvider extends FabricModelProvider {
    public SimpleTophatModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(@NonNull BlockModelGenerators blockModelGenerators) {

    }

    @Override
    public void generateItemModels(@NonNull ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.itemModelOutput.accept(ModItems.TOPHAT, ItemModelUtils.tintedModel(SimpleTophat.id("item/tophat"), new Dye(-1)));
    }

    @Override
    public @NonNull String getName() {
        return "SimpleTophatModelProvider";
    }
}
