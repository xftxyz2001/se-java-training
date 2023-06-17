function isPrime(n) {
    if (n < 2) return false;
    for (var i = 2; i < n; i++) {
        if (n % i == 0) return false;
    }
    return true;
}

function isPrime(n) {
    if (n < 2) return false;
    if (n < 4) return true;
    if (n % 2 == 0 || n % 3 == 0) return false;
    for (var i = 5; i * i <= n; i += 6) {
        if (n % i == 0 || n % (i + 2) == 0) return false;
    }
    return true;
}

function isPrime(num) {
    if (num <= 1) {
        return false;
    }
    if (num <= 3) { // 2, 3
        return true;
    }
    if (num % 2 === 0 || num % 3 === 0) { // 2, 3 的倍数
        return false;
    }
    const s = num - 1;
    let d = s;
    while (d % 2 === 0) {
        d /= 2;
    }
    const k = 20; // 精度参数
    for (let i = 0; i < k; i++) {
        const a = Math.floor(Math.random() * (num - 3)) + 2;
        let x = modPow(a, d, num);
        if (x === 1 || x === s) {
            continue;
        }
        let j = 0;
        while (j < s && x !== s) {
            x = modPow(x, 2, num);
            j++;
        }
        if (x !== s) {
            return false;
        }
    }
    return true;
}

function modPow(base, exp, mod) {
    let result = 1;
    base %= mod;
    while (exp > 0) {
        if (exp % 2 === 1) {
            result = (result * base) % mod;
        }
        exp = Math.floor(exp / 2);
        base = (base * base) % mod;
    }
    return result;
}