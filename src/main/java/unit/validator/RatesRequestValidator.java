package unit.validator;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;


public class RatesRequestValidator {
    public static boolean validateBank(ArrayList<String> ratesList) {
        return StringUtils.isNotEmpty(ratesList.get(7))
                && StringUtils.isNotEmpty(ratesList.get(8))
                && StringUtils.isNotEmpty(ratesList.get(1))
                && StringUtils.isNotEmpty(ratesList.get(2))
                && StringUtils.isNotEmpty(ratesList.get(4))
                && StringUtils.isNotEmpty(ratesList.get(5));
    }

    public static boolean validateUkrSibBank(ArrayList<String> ratesList) {
        return StringUtils.isNotEmpty(ratesList.get(13))
                && StringUtils.isNotEmpty(ratesList.get(14))
                && StringUtils.isNotEmpty(ratesList.get(4))
                && StringUtils.isNotEmpty(ratesList.get(5))
                && StringUtils.isNotEmpty(ratesList.get(10))
                && StringUtils.isNotEmpty(ratesList.get(11));
    }
}
