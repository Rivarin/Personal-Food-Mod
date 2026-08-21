package name.modid;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItemIDs 
{
	public static RegistryKey<Item> create(String name) 
	{
		// Create the item key.
		return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RinsFoodMod.MOD_ID, name));
	}

	public static final RegistryKey<Item> BURGER = create("burger");
	public static final RegistryKey<Item> SINIGANG = create("sinigang");
	public static final RegistryKey<Item> COFFEE = create("coffee");
}