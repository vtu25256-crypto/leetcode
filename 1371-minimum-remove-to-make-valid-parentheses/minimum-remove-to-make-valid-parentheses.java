class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder a = new StringBuilder();
        int open = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') { open++; a.append(c); }
            else if (c == ')' && open > 0) { open--; a.append(c); }
            else if (c != ')') a.append(c);
        }

        for (int i = a.length() - 1; open > 0; i--)
            if (a.charAt(i) == '(') { a.deleteCharAt(i); open--; }

        return a.toString();
    }
}
