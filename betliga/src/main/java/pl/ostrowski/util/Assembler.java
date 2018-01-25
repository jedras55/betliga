package pl.ostrowski.util;

/** Created by Jedras-PC on 25.01.2018. */
public abstract class Assembler<K, V> {

  public abstract V convertToBusiness(K object);

  public abstract K convertToDomain(V object);
}
