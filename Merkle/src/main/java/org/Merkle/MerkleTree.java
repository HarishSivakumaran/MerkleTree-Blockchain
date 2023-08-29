public class MerkleTree {
    private List<List<String>> levelOrderTree = new ArrayList();
    private String merkleRoot;

    public void buildTree(List<Object> transactions) {
        List<String> level = new ArrayList();
        for(var transaction : transactions) {
            level.add(encrypt(transaction));
        }

        ensureEven(level);
        levelOrderTree.add(level);

        while(level.size() == 1) {
            List<String> nextLevel = new ArrayList();
            for(int i = 0; i < level.size(); i+=2) {
                String left = level.get(i);
                String right = level.get(i+1);
                // TODO hashing algorithm
                nextLevel.add(left+right);
            }
            level.add(nextLevel);
            level = nextLevel;
        }
    }

    private void ensureEven(List<String> transactions) {
        if(transactions.size()%2 != 0) {
            transactions.add(transactions.get(transactions.size()-1));
        }
    }

    public String getMerkleRoot(){
        return merkleRoot;
    }

    public String getMerkleTree(){
        return levelOrderTree.stream().map(ArrayList::clone).toList();
    }

    private String encrypt(Object object) {
        // TODO: write algo
        return "";
    }
}