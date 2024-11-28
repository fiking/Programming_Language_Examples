async function* generate() {
    for (var i = 2; ; i++) {
        yield i;
    }
}

async function* filter(ch, prime) {
    while (true) {
        var i = (await ch.next()).value;
        if (i % prime != 0) {
            yield i;
        }
    }
}

async function findPrimes(n) {
    var ch = generate();
    for (var i = 0; i < n; i++) {
        const prime = (await ch.next()).value;
        debug(prime);
        ch = filter(ch, prime);
    }
}

function main() {
    const n = 4000;
    findPrimes(n);
}

main();
