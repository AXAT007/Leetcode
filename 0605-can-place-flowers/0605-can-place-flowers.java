class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int i = 0;

        if (flowerbed.length == 1) {
            if (flowerbed[0] == 1) {
                if (n == 0)
                    return true;
                else
                    return false;
            } else {
                if (n <= 1)
                    return true;
                else
                    return false;
            }
        }

        while (i < flowerbed.length) {
            if(n==0){
                return true;
            }
            if (flowerbed[i] == 1) {
                i += 2;
            } else {

                if (i == flowerbed.length - 1 && flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                    break;
                }

                else if (i == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                    i += 2;
                }

                else if (i > 0 &&
                         i + 1 < flowerbed.length &&
                         flowerbed[i - 1] != 1 &&
                         flowerbed[i + 1] != 1) {

                    flowerbed[i] = 1;
                    n--;
                }

                else {
                    i++;
                }
            }
        }

        return n <= 0;
    }
}