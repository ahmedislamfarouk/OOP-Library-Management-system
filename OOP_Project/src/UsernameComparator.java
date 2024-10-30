import java.util.Comparator;

class UsernameComparator implements Comparator<Account> {
    @Override
    public int compare(Account u1, Account u2) {
        if (u1 == null || u2 == null) {
            if (u1 == null) return -1;
            return 1;
        }
        return u1.getUsername().compareTo(u2.getUsername());
    }
}