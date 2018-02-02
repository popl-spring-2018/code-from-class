
# Define our own higher-order function
# that takes a code block

def one_to_x_squared x
  i = 1
  while i <= x
    yield i * i
    i += 1
  end
end
