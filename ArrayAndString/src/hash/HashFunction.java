package hash;

public class HashFunction {
	// 해시 테이블 크기
		private int M = 31; 

		/*
		 * 제산함수
		 * - 나머지 연산자를 사용하여 탐색 키를 해시 테이블의 크기로 나눈 나머지를 해시 주소로 사용하는 방법
		 * - h(k) = k mod M
		 * - 범위 : 0~(M-1)
		 * - M은 주로 소수가 좋음.
		 * - 나머지 연산 결과가 음수라면 여기에 M을 더해서 결과 값이 0~M-1이 나오게 한다.
		 */
		public int hash_function_mod(int key) {
			int hash_index = key % M;
			if(hash_index < 0) hash_index += M;
			return hash_index;
		}
		
		/*
		 * 폴딩함수
		 * - 이동폴딩 : 탐색 키를 여러 부분으로 나눈 값들을 더하여 해시 주소로 사용한다.
		 * - 경계폴딩 : 탐색 키의 이웃한 부분을 거꾸로 더하여 해시 주소로 사용한다.
		 * - 주로 탐색 키가 해시 테이블의 크기보다 더 큰 정수일 경우에 사용된다.
		 * - 탐색 키의 일부만 사용하는 것이 아니고 몇 개의 부분으로 나누어 이를 더하거나 비트별로 XOR 연산하여 충돌을 줄인다.
		 * 예)
		 * 탐색키 12320324111220 , 해시주소는 10진수 3자리
		 * 이동폴딩 : 123 + 203 + 241 + 112 + 20 = 699
		 * 경계폴딩 : 123 + 302 + 241 + 211 + 20 = 897
		 * 예)
		 * 32비트 키를 2개의 16비트로 나누어 비트별로 XOR 연산
		 * a >> b 는 a / 2^b
		 * a << b 는 a * 2^b
		 */
		public int hash_function_folding(int key) {
			
			return 0;
		}
		
		/*
		 * 탐색 키가 문자열일 경우, 문자에 정수를 할당, 문자의 아스키코드값 사용
		 * - 각 문자의 아스키 코드 값을 모두 더하기
		 * - A~Z 65~90 a~z 97~122
		 * - 가장 좋은 법, 각 문자의 아스키코드*특정양의정수(g)를 곱해서 합하기
		 * - 그냥 문자만 합하면 세자리 수일 경우 범위가 195~366만 나오니깐 특정 수를 곱해서 더하는게 좋다.
		 * - 지수 계산량 줄이기 위해 호너의방법 사용함.
		 * - h = s[0]*31^(n-1) + s[1]*31^(n-2) ..............+s[n-1]; 
		 * - h = ((s[0]*31 + s[1])*31 + s[2])*31 + S[3]....+ S[n-2])*31 + S[n-1] : 호너의 방법
		 * 
		 */
		public int hash_function_string(String key) {
			int hash_index = 0;
			char[] arr_key = key.toCharArray();
			for(int i=0; i < arr_key.length; i++) {
				hash_index = arr_key[i] + hash_index*31;
			}
			return hash_index;
		}
}
