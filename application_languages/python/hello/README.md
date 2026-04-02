# Hello World (Python) ✅

A minimal Python example and unit test.

## Files added

- `hello.py` — contains `greet()` and a small CLI entry point
- `tests/test_hello.py` — simple `unittest` checks

## Run

1. Run the script:

```bash
python hello.py
```

2. Import and use `greet` interactively:

```bash
python -c "from hello import greet; print(greet('Alice'))"
```

3. Run tests:

```bash
python -m unittest discover -s tests
```
