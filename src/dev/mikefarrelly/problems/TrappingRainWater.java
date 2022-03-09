package dev.mikefarrelly.problems;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {
    public static void main(String[] args) {
//        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
//        System.out.println(trap(new int[]{4, 2, 0, 3, 2, 5}));
//        System.out.println(trap(new int[]{4, 2, 3}));
//        System.out.println(trap(new int[]{4, 2, 3, 1, 2}));
//        System.out.println(trap(new int[]{4, 4, 4, 7, 1, 0}));
        System.out.println(trap(new int[]{0, 7, 1, 4, 6}));
        /*
         * =
         * =     =
         * =     =
         * =   = =
         * =   = =
         * =   = =
         * = = = =
         */
    }

    private static int trap(int[] height) {
        if (height == null || height.length < 3) return 0;

        int trappedRain = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] == 0) continue;

            int potentialRainTrap = 0;
            int midRainTrap = 0;
            boolean hasTrappedRain = false;
            boolean hasMidTrappedRain = false;
            int startVal = height[i];
            int lowPoint = Integer.MAX_VALUE;
            boolean endReached = false;
            for (int j = i + 1; j < height.length; j++) {
                if (height.length-1 == j) endReached = true;

                lowPoint = Math.min(lowPoint, height[j]);

                if (height[j] > lowPoint && potentialRainTrap > 0) {
                    midRainTrap += (height[j] - lowPoint);
                    hasMidTrappedRain = true;
                    i = j - 1;
                }

                if (height[j] >= startVal && potentialRainTrap > 0) {
                    hasTrappedRain = true;
                    i = j - 1;
                    break;
                }

                int diff = startVal - height[j];
                if (diff > 0) potentialRainTrap += diff;
            }

            if (hasMidTrappedRain && !hasTrappedRain) {
                trappedRain += midRainTrap;
            } else if (hasTrappedRain) {
                trappedRain += potentialRainTrap;
            }

            if (endReached) break;
        }

        return trappedRain;
    }
}
