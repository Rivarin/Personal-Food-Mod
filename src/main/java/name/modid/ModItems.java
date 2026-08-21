package name.modid;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;

import java.util.function.Function;

public class ModItems 
{
	public static Item register(RegistryKey<Item> itemKey, Function<Item.Settings, Item> itemFactory, Item.Settings settings) 
	{
		Item item = itemFactory.apply(settings.registryKey(itemKey));
		Registry.register(Registries.ITEM, itemKey, item);

		return item;
	}

	//burger
	public static final Item BURGER = register(ModItemIDs.BURGER, Item::new, new Item.Settings().food(new FoodComponent.Builder()
	.nutrition(10).saturationModifier(1f)
	.build()
	));

	//sinigang
	public static final Item SINIGANG = register(ModItemIDs.SINIGANG, Item::new, new Item.Settings()
	.useRemainder(Items.BOWL)
	.maxCount(16)
		.food(new FoodComponent.Builder()
			.nutrition(8).saturationModifier(0.8f)
			.build()
		));

	//coffee
	public static final ConsumableComponent COFFEE_SPEED_COMPONENT = ConsumableComponents.drink()
		.consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SPEED, 1200, 0), 1.0f))
		.build();
	public static final FoodComponent COFFEE_COMPONENT = new FoodComponent.Builder()
		.nutrition(5).saturationModifier(0.2f)
		.alwaysEdible()
		.build();

	public static final Item COFFEE = register(ModItemIDs.COFFEE, Item::new, new Item.Settings()
	.useRemainder(Items.GLASS_BOTTLE)
	.maxCount(16)
		.food(COFFEE_COMPONENT, COFFEE_SPEED_COMPONENT));


	//initialize
	public static void initialize() 
	{
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
		.register((itemGroup) -> 
		{
			itemGroup.add(ModItems.BURGER);
			itemGroup.add(ModItems.SINIGANG);
			itemGroup.add(ModItems.COFFEE);
		});
	}
}