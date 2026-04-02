#!/usr/bin/env python3
"""Simple Hello World example."""

from __future__ import annotations


def greet(name: str = "World") -> str:
    """Return a greeting message."""
    return f"Hello, {name}!"


def main() -> None:
    """CLI entry point printing the default greeting."""
    print(greet())


if __name__ == "__main__":
    main()
