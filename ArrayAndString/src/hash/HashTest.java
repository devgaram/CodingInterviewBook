package hash;

public class HashTest {

	public static void main(String[] args) {
		HashTable hashTable = new HashTable(31);

		hashTable.put("aaa", "bbbbb");
		hashTable.put("bbb", "ccccc");
		hashTable.put("ccc", "ddddd");
		hashTable.put("ddd", "eeeee");
		System.out.println(hashTable);
		System.out.println(hashTable.get("aaa"));
		System.out.println(hashTable.get("bbb"));
		System.out.println(hashTable.size());
		System.out.println(hashTable.contains("ccc"));
		System.out.println(hashTable.isEmpty());
		hashTable.remove("bbb");
		System.out.println(hashTable.get("ccc"));
		System.out.println(hashTable);
		
	}

}
