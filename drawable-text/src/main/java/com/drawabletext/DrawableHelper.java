package com.drawabletext;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;

import com.amulyakhare.textdrawable.util.ColorGenerator;

/**
 * Created by Nikolay Unuchek on 29.04.2016.
 */
public class DrawableHelper {

    private static String splitName(String name) {
        String firstSymbols = "";
        try {
            if (TextUtils.isEmpty(name)) {
                return firstSymbols;
            }
            String[] names = name.split(" ");
            for (String entry : names) {
                firstSymbols = firstSymbols + entry.substring(0, 1);
            }
        } catch (Throwable nothing) {
        }
        return firstSymbols;
    }

    private static String splitNames(String firstName, String lastName) {
        String firstSymbols = (TextUtils.isEmpty(firstName) ? "" : firstName.substring(0, 1))
                + (TextUtils.isEmpty(lastName) ? "" : lastName.substring(0, 1));
        return firstSymbols;
    }

    public static Drawable getDrawableForName(String name) {
        ColorGenerator generator = ColorGenerator.MATERIAL;
        String firstSymbols = splitName(name);
        int color = generator.getColor(firstSymbols);
        return TextDrawable.builder().buildRound(firstSymbols, color);
    }

    public static Drawable getDrawableForNameWithBorder(String name) {
        ColorGenerator generator = ColorGenerator.MATERIAL;
        String firstSymbols = splitName(name);
        int color = generator.getColor(firstSymbols);
        return TextDrawable.builder()
                .beginConfig()
                .withBorder(2, Color.WHITE) //border
                .toUpperCase()
                .endConfig()
                .buildRound(firstSymbols, color);
    }

    public static Drawable getDrawableForName(String firstName, String lastName) {
        ColorGenerator generator = ColorGenerator.MATERIAL;
        int color = generator.getColor(splitNames(firstName, lastName));
        return TextDrawable.builder().buildRound(splitNames(firstName, lastName), color);
    }

    public static Drawable getDrawableForNameWithBorder(String name, int color) {
        return TextDrawable.builder()
                .beginConfig()
                .withBorder(2, Color.WHITE) //border
                .toUpperCase()
                .endConfig()
                .buildRound(splitName(name), color);
    }
}