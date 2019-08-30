
public class LRUQuestion {
	public static void main(String[] args) {
		
		String[] cities1 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		System.out.println("실행시간 : " + testCache(3,cities1));
		String[] cities2 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
		System.out.println("실행시간 : " + testCache(3,cities2));
		String[] cities3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
		System.out.println("실행시간 : " + testCache(2,cities3));
		String[] cities4 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
		System.out.println("실행시간 : " + testCache(5,cities4));
		String[] cities5 = {"Jeju", "Pangyo", "NewYork", "newyork"};
		System.out.println("실행시간 : " + testCache(2,cities5));
		String[] cities6 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		System.out.println("실행시간 : " + testCache(0,cities6));
	}
	
	public static int testCache(int cacheSize, String[] cities) {
		Cache cache = new Cache(cacheSize);
		for (String city : cities)
			cache.insertResults(city);
		
		return cache.getTime();
	}
}
