package name.modid;

import net.fabricmc.api.ModInitializer;

public class RinsFoodMod implements ModInitializer 
{

	public static final String MOD_ID = "rinsfood";

	@Override
	public void onInitialize() 
	{
		ModItems.initialize();
	}
}