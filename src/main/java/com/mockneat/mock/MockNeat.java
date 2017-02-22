package com.mockneat.mock;

/**
 * Copyright 2017, Andrei N. Ciobanu

 Permission is hereby granted, free of charge, to any user obtaining a copy of this software and associated
 documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 persons to whom the Software is furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

import com.mockneat.mock.interfaces.*;
import com.mockneat.mock.unit.financial.CVVS;
import com.mockneat.mock.unit.networking.*;
import com.mockneat.mock.unit.objects.Objs;
import com.mockneat.mock.unit.text.Files;
import com.mockneat.mock.unit.text.Markovs;
import com.mockneat.mock.unit.time.LocalDates;
import com.mockneat.mock.unit.types.*;
import com.mockneat.mock.unit.user.Passwords;
import com.mockneat.mock.unit.user.Users;
import com.mockneat.mock.utils.ValidationUtils;
import com.mockneat.mock.unit.address.Countries;
import com.mockneat.mock.unit.financial.CCS;
import com.mockneat.mock.unit.financial.Currencies;
import com.mockneat.mock.unit.financial.Money;
import com.mockneat.mock.unit.id.UUIDs;
import com.mockneat.mock.unit.text.Dicts;
import com.mockneat.mock.unit.text.Strings;
import com.mockneat.mock.unit.time.Days;
import com.mockneat.mock.unit.time.Months;
import com.mockneat.mock.unit.user.Emails;
import com.mockneat.mock.unit.user.Names;
import com.mockneat.types.enums.RandType;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;

import static org.apache.commons.lang3.Validate.notEmpty;
import static org.apache.commons.lang3.Validate.notNull;

@SuppressWarnings("unchecked")
public class MockNeat {

    private Random random;

    private Bools rBools;
    private Countries rCountries;
    private CCS rCCS;
    private Chars rChars;
    private Currencies rCurrencies;
    private CVVS rCVVS;
    private Days rDays;
    private Dicts rDicts;
    private Domains rDomains;
    private Doubles rDoubles;
    private Emails rEmails;
    private Files rFiles;
    private Floats rFloats;
    private Ints rInts;
    private IPv4s rIPv4s;
    private IPv6s rIPv6s;
    private LocalDates rLocalDates;
    private Longs rLongs;
    private Macs rMacs;
    private Markovs rMarkovs;
    private Money rMoney;
    private Months rMonths;
    private Names rNames;
    private Passwords rPasswords;
    private UUIDs rUUIDs;
    private Users rUsers;

    protected MockNeat(RandType randomType) {
        this.random = randomType.getRandom();

        this.rChars = new Chars(this);
        this.rBools = new Bools(this);
        this.rCountries = new Countries(this);
        this.rCCS = new CCS(this);
        this.rCurrencies = new Currencies(this);
        this.rCVVS = new CVVS(this);
        this.rDays = new Days(this);
        this.rDomains = new Domains(this);
        this.rDicts = new Dicts(this);
        this.rDoubles = new Doubles(this);
        this.rEmails = new Emails(this);
        this.rFiles = new Files(this);
        this.rFloats = new Floats(this);
        this.rInts = new Ints(this);
        this.rIPv4s = new IPv4s(this);
        this.rIPv6s = new IPv6s(this);
        this.rLocalDates = new LocalDates(this);
        this.rLongs = new Longs(this);
        this.rMacs = new Macs(this);
        this.rMarkovs = new Markovs(this);
        this.rMoney = new Money(this);
        this.rMonths = new Months(this);
        this.rNames = new Names(this);
        this.rPasswords = new Passwords(this);
        this.rUUIDs = new UUIDs();
        this.rUsers = new Users(this);
    }

    protected MockNeat() {
        this(RandType.THREAD_LOCAL_RANDOM);
    }

    protected MockNeat(RandType randomType, Long seed) {
        this(randomType);
        random.setSeed(seed);
    }

    public static MockNeat threadLocal() { return new MockNeat(RandType.THREAD_LOCAL_RANDOM); }
    public static MockNeat secure() { return new MockNeat(RandType.SECURE_RANDOM); }
    public static MockNeat old() { return new MockNeat(RandType.RANDOM); }

    public Bools bools() {
        return this.rBools;
    }

    public CCS ccs() {
        return this.rCCS;
    }

    public Chars chars() { return this.rChars; }

    public Countries countries() {
        return this.rCountries;
    }

    public Currencies currencies() { return this.rCurrencies; }

    public CVVS cvvs() { return this.rCVVS; }

    public Dicts dicts() {
        return this.rDicts;
    }

    public Days days() { return this.rDays; }

    public Domains domains() { return this.rDomains;}

    public Doubles doubles() {
        return this.rDoubles;
    }

    public Emails emails() { return this.rEmails; }

    public Files files() { return this.rFiles; }

    public Floats floats() { return this.rFloats; }

    public Ints ints() { return this.rInts; }

    public IPv4s ipv4s() { return this.rIPv4s; }

    public IPv6s iPv6s() { return this.rIPv6s; }

    public LocalDates localDates() { return this.rLocalDates; }

    public Longs longs() { return this.rLongs; }

    public Macs macs() { return this.rMacs; }

    public Markovs markovs() { return this.rMarkovs; }

    public <T> Objs<T> objs(Class<T> cls) { return new Objs<>(this, cls); }

    public Months months() { return this.rMonths; }

    public Money money() { return this.rMoney; }

    public Names names() { return this.rNames; }

    public Passwords passwords() { return this.rPasswords; }

    public Strings strings() { return new Strings(this); }

    public URLs urls() { return new URLs(this); }

    public UUIDs uuids() { return this.rUUIDs; }

    public Users users() { return this.rUsers; }

    public Random getRandom() {
        return random;
    }

    public <T> MockUnit<T> from(List<T> alphabet) {
        notEmpty(alphabet, ValidationUtils.INPUT_PARAMETER_NOT_NULL_OR_EMPTY, "alphabet");
        Supplier<T> supp = () -> {
            int idx = getRandom().nextInt(alphabet.size());
            return alphabet.get(idx);
        };
        return () -> supp;
    }

    public <T> MockUnit<T> from(T... alphabet) {
        notEmpty(alphabet, ValidationUtils.INPUT_PARAMETER_NOT_NULL_OR_EMPTY, "alphabet");
        Supplier<T> supp = () -> {
            int idx = getRandom().nextInt(alphabet.length);
            return alphabet[idx];
        };
        return () -> supp;
    }

    public <T extends Enum<?>> MockUnit<T> from(Class<T> enumClass) {
        notNull(enumClass, ValidationUtils.INPUT_PARAMETER_NOT_NULL, "enumClass");
        T[] arr = enumClass.getEnumConstants();
        return from(arr);
    }

    public <T> MockUnit<T> fromKeys(Map<T, ?> map) {
        notEmpty(map, ValidationUtils.INPUT_PARAMETER_NOT_NULL_OR_EMPTY, "map");
        Supplier<T> supp = () -> {
            T[] keys = (T[]) map.keySet().toArray();
            int idx = getRandom().nextInt(keys.length);
            return keys[idx];
        };
        return () -> supp;
    }

    public <T> MockUnit<T> fromValues(Map<?, T> map) {
        notEmpty(map, ValidationUtils.INPUT_PARAMETER_NOT_NULL_OR_EMPTY, "map");
        Supplier<T> supp = () -> {
            T[] values = (T[]) map.values().toArray();
            int idx = getRandom().nextInt(values.length);
            return values[idx];
        };
        return () -> supp;
    }

    public MockUnitInt fromInts(Integer[] alphabet) {
        return () -> from(alphabet)::val;
    }

    public MockUnitInt fromInts(int[] alphabet) {
        return () -> this.ints().from(alphabet)::val;
    }

    public MockUnitInt fromInts(List<Integer> alphabet) {
        return () -> from(alphabet)::val;
    }

    public MockUnitInt fromIntsValues(Map<?, Integer> map) {
        return () -> fromValues(map)::val;
    }

    public MockUnitInt fromIntsKeys(Map<Integer, ?> map) {
        return () -> fromKeys(map)::val;
    }

    public MockUnitDouble fromDoubles(Double[] alphabet) {
        return () -> from(alphabet)::val;
    }

    public MockUnitDouble fromDoubles(double[] alphabet) {
        return () -> this.doubles().from(alphabet)::val;
    }

    public MockUnitDouble fromDoubles(List<Double> alphabet) {
        return () -> from(alphabet)::val;
    }

    public MockUnitDouble fromDoublesValues(Map<?, Double> map) {
        return () -> fromValues(map)::val;
    }

    public MockUnitDouble fromDoublesKeys(Map<Double, ?> map) {
        return () -> fromKeys(map)::val;
    }

    public MockUnitLong fromLongs(Long[] alphabet) {
        return () -> from(alphabet)::val;
    }

    public MockUnitLong fromLongs(long[] alphabet) {
        return () -> this.longs().from(alphabet)::val;
    }

    public MockUnitLong fromLongs(List<Long> alphabet) {
        return () -> from(alphabet)::val;
    }

    public MockUnitLong fromLongsValues(Map<?, Long> map) {
        return () -> fromValues(map)::val;
    }

    public MockUnitLong fromLongsKeys(Map<Long, ?> map) {
        return () -> fromKeys(map)::val;
    }

    public MockUnitString fromStrings(String[] alphabet) {
        return () -> from(alphabet)::val;
    }

    public MockUnitString fromStrings(List<String> alphabet) {
        return () -> from(alphabet)::val;
    }

    public MockUnitString fromStringsValues(Map<?, String> map) {
        return () -> fromValues(map)::val;
    }

    public MockUnitString fromStringsKeys(Map<String, ?> map) {
        return () -> fromKeys(map)::val;
    }
}