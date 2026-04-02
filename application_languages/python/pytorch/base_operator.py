import torch

x = torch.arange(12)
print(x)

print(x.shape)
print(x.size())
print(x.numel())

x = x.reshape(3, 4)
print(x)

print(torch.zeros((2, 3, 4)))
print(torch.ones((2, 3, 4)))

print(torch.randn((3, 4)))

print(type(x))