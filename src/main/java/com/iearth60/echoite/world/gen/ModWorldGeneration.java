package com.iearth60.echoite.world.gen;

public class ModWorldGeneration {
    public static void generateModWorldGen()
    {
        ModOreGeneration.generateOres();

        ModBushGeneration.generateBushes();
    }
}
