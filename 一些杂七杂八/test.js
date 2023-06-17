var [empty1, empty2, full1, full2] = [1, 1, 0, 0];
PC()
{
    while (1) {
        // compute next number;
        Wait(empty1);
        Wait(empty2);
        // Add the number to buffer;
        Signal(full1);
        Signal(full2);
    }
}
PO1()
{
    while (1) {
        wait(full1);
        // Take from buffer;
        Signal(empty1);
        // Print last number;
    }
}
PO2()
{
    while (1) {
        wait(full1);
        // Take from buffer;
        Signal(empty1);
        // Print last number;
    }
}