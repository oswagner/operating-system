defmodule SystemCalls do
    def main do
        numbers = File.stream!("numbers", []) # chamada de sistema => ler arquivo do disco
                    |> Stream.map( fn x -> String.trim(x) |> String.to_integer end)
                    |> Enum.to_list

        operation = IO.gets("Operation ?\n") |> String.trim # chamada de sistema => ler na tela

        result = case operation do
            "+" -> evaluate(numbers, operation)
            "-" -> evaluate(numbers, operation)
            _ -> IO.puts("Invalid operation") # chamada de sistema => imprimir na tela
        end

        IO.puts(result) # chamada de sistema => imprimir na tela
    end

    def evaluate(numbers, operation) when operation == "+" do
        IO.puts("Soma") # chamada de sistema => imprimir na tela
        numbers |> Enum.reduce(fn x, acc -> x + acc end)
    end
    
    def evaluate(numbers, operation) when operation == "-" do
        IO.puts("Subtrai") # chamada de sistema => imprimir na tela
        numbers |> Enum.reduce(fn x, acc -> x - acc end)
    end
end


SystemCalls.main