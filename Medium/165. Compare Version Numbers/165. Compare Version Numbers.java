class Solution {
    public int compareVersion(String version1, String version2) {
        ArrayList<Integer> v1Nums= new ArrayList<>();
        ArrayList<Integer> v2Nums= new ArrayList<>();
        int begin = 0;
        for (int i = 0; i < version1.length(); i++) {
            if (version1.charAt(i) == '.') {
                v1Nums.add(Integer.parseInt(version1.substring(begin, i)));
                begin = i + 1;
            }
        }
        v1Nums.add(Integer.parseInt(version1.substring(begin)));
        begin = 0;
        for (int i = 0; i < version2.length(); i++) {
            if (version2.charAt(i) == '.') {
                v2Nums.add(Integer.parseInt(version2.substring(begin, i)));
                begin = i + 1;
            }
        }
        v2Nums.add(Integer.parseInt(version2.substring(begin)));
        
        int i;
        for (i = 0; i < v2Nums.size(); i++) {
            if (i >= v1Nums.size()) {
                if (v2Nums.get(i) != 0)
                    return -1;
                else
                    continue;
            }
            if (v1Nums.get(i) > v2Nums.get(i))
                return 1;
            else if (v1Nums.get(i) < v2Nums.get(i))
                return -1;
        }
        for (; i < v1Nums.size(); i++) {
            if (v1Nums.get(i) != 0)
                return 1;
        }
        return 0;
    }
}
