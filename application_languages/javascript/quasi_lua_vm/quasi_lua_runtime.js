function Table() {
  // Map from ES Harmony is a simple dictionary-style collection.
  this.map = new Map;
}

Table.prototype = {
  load: function (key) { return this.map.get(key); },
  store: function (key, value) { this.map.set(key, value); }
};

function CHECK_TABLE(t) {
  if (!(t instanceof Table)) {
    throw new Error("table expected");
  }
}

function LOAD(t, k) {
  CHECK_TABLE(t);
  return t.load(k);
}

function STORE(t, k, v) {
  CHECK_TABLE(t);
  t.store(k, v);
}

var os = new Table();
STORE(os, 'clock', function() {
  return Date.now() / 1000;
});



function MakePoint(x, y) {
  var point = new Table();
  STORE(point, 'x', x);
  STORE(point, 'y', y);
  return point;
}

function MakeArrayOfPoints(N) {
  var array = new Table();
  var m = -1;
  for (var i = 0; i <= N; i++) {
    m = m * -1;
    STORE(array, i, MakePoint(m * i, m * -i));
  }
  STORE(array, 'n', N);
  return array;
}

function SumArrayOfPoints(array) {
  var sum = MakePoint(0, 0);
  for (var i = 0; i <= LOAD(array, 'n'); i++) {
    STORE(sum, 'x', LOAD(sum, 'x') + LOAD(LOAD(array, i), 'x'));
    STORE(sum, 'y', LOAD(sum, 'y') + LOAD(LOAD(array, i), 'y'));
  }
  return sum;
}

function CheckResult(sum) {
  var x = LOAD(sum, 'x');
  var y = LOAD(sum, 'y');
  if (x !== 50000 || y !== -50000) {
    throw new Error("failed: x = " + x + ", y = " + y);
  }
}

var N = 100000;
var array = MakeArrayOfPoints(N);
var start = LOAD(os, 'clock')() * 1000;
for (var i = 0; i <= 5; i++) {
  var sum = SumArrayOfPoints(array);
  CheckResult(sum);
}
var end = LOAD(os, 'clock')() * 1000;
console.log(end - start);
