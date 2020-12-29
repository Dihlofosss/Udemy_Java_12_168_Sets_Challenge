package com.timbuchalka;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dev on 12/01/2016.
 */
public class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final BodyType bodyType;

    public HeavenlyBody(BodyType bodyType, String name, double orbitalPeriod) {
        this.name = name;
        this.bodyType = bodyType;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public BodyType getBodyType()
    {
        return bodyType;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSatellite(HeavenlyBody moon) {
        return moon.getBodyType() == BodyType.MOON ? this.satellites.add(moon) : false;
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }


    @Override
    public final boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if (obj instanceof HeavenlyBody)
        {
            HeavenlyBody newBody = (HeavenlyBody) obj;
            return newBody.getName().equals(this.getName()) && newBody.getBodyType().equals(this.getBodyType());
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.name.hashCode() + 57;
    }

    @Override
    public String toString()
    {
        return this.name + ",\t" + this.bodyType + ",\t" + this.orbitalPeriod;
    }
}
