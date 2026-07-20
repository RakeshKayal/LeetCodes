class Solution {
    public List<Integer> findSubstring(String s1, String[] words) {

        Map<String, Integer> fre1 = new HashMap<>();

        for (String s : words) {
            fre1.put(s, fre1.getOrDefault(s, 0) + 1);
        }

        int n = words[0].length();

        int total = n * words.length;

        

        List<Integer> ans = new ArrayList<>();

    

        for (int st = 0; st < n; st++) {

            int l = st;
            int j = st;
            Map<String, Integer> fre2 = new HashMap<>();
            String a = "";

            while (j < s1.length()) {

                a += s1.charAt(j);

                if (a.length() == n) {
                    if (fre1.containsKey(a)) {
                        fre2.put(a, fre2.getOrDefault(a, 0) + 1);
                        String temp = "";
                        while (fre2.get(a) > fre1.get(a)) {

                            temp += s1.charAt(l);
                            if (temp.length() == n) {
                                fre2.put(temp, fre2.get(temp) - 1);
                                if (fre2.get(temp) <= 0) {
                                    fre2.remove(temp);

                                }
                                temp = "";
                            }
                            l++;
                        }

                        a = "";

                    } else {
                        a = "";
                        l = j + 1;
                        fre2.clear();
                    }
                }

                if (j - l + 1 == total && fre2.size() == fre1.size()) {
                    ans.add(l);
                }

                j++;

            }

        }

        return ans;

    }
}